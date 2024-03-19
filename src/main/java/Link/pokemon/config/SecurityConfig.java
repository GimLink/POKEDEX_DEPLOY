package Link.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable);

        http.formLogin((form) -> {
            form
                    .loginPage("/login/loginForm")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home");
        });


        http.httpBasic((basic)->
                basic.disable());


        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/pokemons/**").authenticated()
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().permitAll());
가


        return http.build();
    }

}
