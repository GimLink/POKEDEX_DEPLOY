package Link.pokemon.repository;

import Link.pokemon.domain.Pokemon;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@Repository
public class PokemonRepository implements PokeRepository {

    private final EntityManager em;

    public PokemonRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        Pokemon pokemon = em.find(Pokemon.class, id);
        return Optional.ofNullable(pokemon);
    }
}
