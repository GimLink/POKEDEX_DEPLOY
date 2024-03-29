package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
import Link.pokemon.repository.pokemon.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokemonService implements PokeService{

    private final PokemonRepository repository;
    @Override
    public Optional<Pokemon> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pokemon save(MultipartHttpServletRequest mtfRequest, Pokemon pokemon) {
        return null;
    }

    @Override
    public void update(Long pokemonId, PokemonUpdateDto updateParam) {

    }

    @Override
    public List<Pokemon> findAll(PokemonSearchCond cond) {
        return null;
    }
}
