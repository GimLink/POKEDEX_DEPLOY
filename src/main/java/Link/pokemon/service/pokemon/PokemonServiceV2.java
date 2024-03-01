package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
import Link.pokemon.repository.pokemon.PokemonQueryRepository;
import Link.pokemon.repository.pokemon.PokemonRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PokemonServiceV2 implements PokeService{

    private final PokemonRepositoryV2 pokemonRepositoryV2;
    private final PokemonQueryRepository pokemonQueryRepository;

    @Override
    public Pokemon save(Pokemon pokemon) {
        return pokemonRepositoryV2.save(pokemon);
    }


    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepositoryV2.findById(id);
    }

    @Override
    public void update(Long pokemonId, PokemonUpdateDto updateParam) {
        Pokemon findPokemon = pokemonRepositoryV2.findById(pokemonId).orElseThrow();

        findPokemon.setIdPokemon(updateParam.getIdPokemon());
        findPokemon.setPokemonName(updateParam.getPokemonName());
        findPokemon.setAttack(updateParam.getAttack());
        findPokemon.setDefense(updateParam.getDefense());
        findPokemon.setSpecialAttack(updateParam.getSpecialAttack());
        findPokemon.setSpecialDefense(updateParam.getSpecialDefense());
        findPokemon.setSpeed(updateParam.getSpeed());

        findPokemon.setTypes(updateParam.getTypes());
    }

    @Override
    public List<Pokemon> findAll(PokemonSearchCond cond) {
        return pokemonQueryRepository.findAll(cond);
    }
}
