package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;

import java.util.Optional;

public interface PokeRepository {
    Optional<Pokemon> findById(Long id);

    Pokemon save(Pokemon pokemon);

    void update(Long pokemonId, PokemonUpdateDto updateParam);

}
