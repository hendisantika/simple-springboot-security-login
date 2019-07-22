package com.hendisantika.simplespringbootsecuritylogin.config

import com.hendisantika.simplespringbootsecuritylogin.model.Role
import com.hendisantika.simplespringbootsecuritylogin.model.User
import com.hendisantika.simplespringbootsecuritylogin.repository.UserRepository
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

/**
 * Created by IntelliJ IDEA.
 * Project : simple-springboot-security-login
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-23
 * Time: 05:04
 */
@Component
class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserRepository userRepository

    Logger log = LoggerFactory.getLogger(this.class)

    @Override
    void onApplicationEvent(final ApplicationReadyEvent event) {
        log.info 'Verifying if default user exist'
        createUserWithRole('naruto', '1234', 'uzumaki.naruto@konohagakure.com', Role.USER)
    }

    private createUserWithRole(String username, String password, String email, Role authority) {
        if (!userRepository.findByUsername(username)) {
            User user = new User(
                    username: username,
                    password: new BCryptPasswordEncoder().encode(password),
                    email: email,
                    role: authority,
                    firstname: username,
                    lastname: username,
                    enabled: true
            )
            userRepository.save(user)
        }
    }

}