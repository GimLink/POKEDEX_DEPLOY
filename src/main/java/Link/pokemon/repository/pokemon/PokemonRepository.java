package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
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

    @Override
    public Pokemon save(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @Override
    public void update(Long pokemonId, PokemonUpdateDto updateParam) {
        Pokemon findPokemon = repository.findById(pokemonId).orElseThrow();

        findPokemon.setIdPokemon(updateParam.getIdPokemon());
        findPokemon.setPokemon(updateParam.getPokemon());
        findPokemon.setHp(updateParam.getHp());
        findPokemon.setAttack(updateParam.getAttack());
        findPokemon.setDefense(updateParam.getDefense());
        findPokemon.setSpecialAttack(updateParam.getSpecialAttack());
        findPokemon.setSpecialDefense(updateParam.getSpecialDefense());
        findPokemon.setSpeed(updateParam.getSpeed());
    }
}
