package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;

import java.util.Optional;

public interface PokeService {

    Optional<Pokemon> findById(Long id);

}
