package Link.pokemon;

import Link.pokemon.config.Member.MemberConfig;
import Link.pokemon.config.Pokemon.PokemonConfigV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Import((PokemonConfig.class))
@Import({PokemonConfigV2.class, MemberConfig.class})
@SpringBootApplication
public class PokemonApplication {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

}
