package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.repository.pokemon.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokemonService implements PokeService{

    private final PokemonRepository repository;
    @Override
    public Optional<Pokemon> findById(Long id) {
        return repository.findById(id);
    }
}
