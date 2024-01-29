package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
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

    private final EntityManager em;

    private final JPAQueryFactory query;

    public PokemonRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        Pokemon pokemon = em.find(Pokemon.class, id);
        return Optional.ofNullable(pokemon);}

    @Override
    public Pokemon save(Pokemon pokemon) {
        em.persist(pokemon);
        return pokemon;
    }

    @Override
    public void update(Long pokemonId, PokemonUpdateDto updateParam) {
        Pokemon findPokemon = em.find(Pokemon.class, pokemonId);

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
