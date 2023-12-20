package Link.pokemon.repository;

import Link.pokemon.domain.Pokemon;

import java.util.Optional;

public interface PokeRepository {
    Optional<Pokemon> findById(Long id);

}
