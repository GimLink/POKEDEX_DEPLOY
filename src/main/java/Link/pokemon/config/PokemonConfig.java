package Link.pokemon.config;

import Link.pokemon.repository.PokeRepository;

import Link.pokemon.repository.PokemonRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokemonConfig {
    private final EntityManager em;

    public PokemonConfig(EntityManager em) {
        this.em = em;
    }

    public PokeRepository pokeRepository() {
        return new PokemonRepository(em);
    }
}
