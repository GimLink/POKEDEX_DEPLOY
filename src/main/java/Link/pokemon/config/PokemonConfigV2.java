package Link.pokemon.config;

import Link.pokemon.repository.pokemon.PokemonQueryRepository;
import Link.pokemon.repository.pokemon.PokemonRepositoryV2;
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

    @Bean
    public PokeService pokemonService() {
        return new PokemonServiceV2(pokemonRepositoryV2, pokemonQueryRepository());
    }

    @Bean
    public PokemonQueryRepository pokemonQueryRepository() {
        return new PokemonQueryRepository(em);
    }

}
