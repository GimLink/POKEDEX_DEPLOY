package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;

import java.util.Optional;

public interface PokeRepository {
    Optional<Pokemon> findById(Long id);

}
