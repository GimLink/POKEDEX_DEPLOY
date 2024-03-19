package Link.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

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


}
