import com.hendisantika.simplespringbootsecuritylogin.model.User
import com.hendisantika.simplespringbootsecuritylogin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository

    @Override
    org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepostory.findByUsername(username)
        Set<GrantedAuthority> grantedAuthorities = [] as Set
        grantedAuthorities << new SimpleGrantedAuthority(user.role.toString())
        new org.springframework.security.core.userdetails.User(user.username, user.password, grantedAuthorities)
    }

}