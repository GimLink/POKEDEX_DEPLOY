package Link.pokemon.config.Pokemon;

import Link.pokemon.repository.pokemon.PokemonQueryRepository;
import Link.pokemon.repository.pokemon.PokemonRepositoryV2;
import Link.pokemon.service.S3.AwsS3Service;
import Link.pokemon.service.pokemon.PokeService;
import Link.pokemon.service.pokemon.PokemonServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PokemonConfigV2 {

    private final EntityManager em;
    private final PokemonRepositoryV2 pokemonRepositoryV2;
    private final AwsS3Service awsS3Service;

    @Bean
    public PokeService pokemonService() {
        return new PokemonServiceV2(pokemonRepositoryV2, pokemonQueryRepository(), awsS3Service);
    }

    @Bean
    public PokemonQueryRepository pokemonQueryRepository() {
        return new PokemonQueryRepository(em);
    }

}
