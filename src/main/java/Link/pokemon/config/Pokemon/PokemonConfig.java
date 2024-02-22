package Link.pokemon.config.Pokemon;

import Link.pokemon.repository.pokemon.PokeRepository;

import Link.pokemon.repository.pokemon.PokemonRepository;
import Link.pokemon.repository.pokemon.SpringDataJpaPokeRepository;
import Link.pokemon.service.pokemon.PokemonService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@RequiredArgsConstructor
public class PokemonConfig {
    private final EntityManager em;

    @Bean
    public PokemonService pokemonService() {
        return new PokemonService(pokemonRepository());
    }

    @Bean
    public PokemonRepository pokemonRepository() {
        return new PokemonRepository(em);
    }
}
