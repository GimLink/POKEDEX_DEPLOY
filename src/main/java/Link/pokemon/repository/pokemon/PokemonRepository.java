package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@Repository
@RequiredArgsConstructor
public class PokemonRepository implements PokeRepository {

    private final SpringDataJpaPokeRepository repository;

    @Override
    public Optional<Pokemon> findById(Long id) {
        return repository.findById(id);}
}
