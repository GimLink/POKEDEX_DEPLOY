package Link.pokemon;

import Link.pokemon.config.Member.MemberConfig;
import Link.pokemon.config.Pokemon.PokemonConfigV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import((PokemonConfig.class))
@Import({PokemonConfigV2.class, MemberConfig.class})
@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

}
