package com.hendisantika.simplespringbootsecuritylogin.repository;

import com.hendisantika.simplespringbootsecuritylogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : simple-springboot-security-login
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-22
 * Time: 07:47
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(User user);

}
