package Link.pokemon;

import Link.pokemon.config.PokemonConfig;
import Link.pokemon.config.PokemonConfigV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import((PokemonConfig.class))
@Import(PokemonConfigV2.class)
@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

}
