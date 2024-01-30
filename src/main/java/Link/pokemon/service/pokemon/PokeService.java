package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PokeService {

    Optional<Pokemon> findById(Long id);

    Pokemon save(Pokemon pokemon);

    void update(Long pokemonId, PokemonUpdateDto updateParam);

    List<Pokemon> findAll(PokemonSearchCond cond);

}
