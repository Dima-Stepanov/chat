package my.websocket.chat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 22.02.2024
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password("{noop}password")
                .roles("GUEST")
                .build();
        UserDetails user2 = User.builder()
                .username("user2")
                .password("{noop}password")
                .roles("GUEST")
                .build();
        UserDetails user3 = User.builder()
                .username("user3")
                .password("{noop}password")
                .roles("GUEST")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
