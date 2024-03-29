package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface PokeService {

    Pokemon save(MultipartHttpServletRequest mtfRequest, Pokemon pokemon) throws IOException;

    Optional<Pokemon> findById(Long id);

    void update(Long pokemonId, PokemonUpdateDto updateParam);

    List<Pokemon> findAll(PokemonSearchCond cond);

}
