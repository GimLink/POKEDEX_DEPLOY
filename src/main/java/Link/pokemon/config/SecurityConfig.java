package Link.pokemon.config;

import Link.pokemon.web.auth.CustomAuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable);

        http.formLogin((form) -> {
            form
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
                    .failureHandler(customAuthFailureHandler())
                    .usernameParameter("loginId");
        });



        http.httpBasic((basic)->
                basic.disable());


//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());


        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/pokemons/**").authenticated()
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().permitAll());


        return http.build();
    }

    @Bean
    AuthenticationFailureHandler customAuthFailureHandler() {
        return new CustomAuthFailureHandler();
    }


}
