package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static Link.pokemon.domain.pokemon.QPokemon.pokemon1;

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

        findPokemon.setPokemon(updateParam.getPokemon());
        findPokemon.setHp(updateParam.getHp());
        findPokemon.setAttack(updateParam.getAttack());
        findPokemon.setDefense(updateParam.getDefense());
        findPokemon.setSpecialAttack(updateParam.getSpecialAttack());
        findPokemon.setSpecialDefense(updateParam.getSpecialDefense());
        findPokemon.setSpeed(updateParam.getSpeed());
    }

    @Override
    public List<Pokemon> findAll(PokemonSearchCond cond) {

        Integer hp = cond.getHp();
        Integer attack = cond.getAttack();
        Integer defense = cond.getDefense();
        Integer specialAttack = cond.getSpecialAttack();
        Integer specialDefense = cond.getSpecialDefense();
        Integer speed = cond.getSpeed();

        return query
                .select(pokemon1)
                .from(pokemon1)
                .where(maxHp(hp), maxAttack(attack), maxDefense(defense), maxSattack(specialAttack),
                        maxSdefense(specialDefense), maxSpeed(speed))
                .fetch();

    }

    private BooleanExpression maxHp(Integer maxHp) {
        if (maxHp != null) {
            return pokemon1.hp.loe(maxHp);
        }
        return null;
    }

    private BooleanExpression maxAttack(Integer maxAttack) {
        if (maxAttack != null) {
            return pokemon1.hp.loe(maxAttack);
        }
        return null;
    }

    private BooleanExpression maxDefense(Integer maxDefense) {
        if (maxDefense != null) {
            return pokemon1.hp.loe(maxDefense);
        }
        return null;
    }

    private BooleanExpression maxSattack(Integer maxSattack) {
        if (maxSattack != null) {
            return pokemon1.hp.loe(maxSattack);
        }
        return null;
    }

    private BooleanExpression maxSdefense(Integer maxSdefense) {
        if (maxSdefense != null) {
            return pokemon1.hp.loe(maxSdefense);
        }
        return null;
    }

    private BooleanExpression maxSpeed(Integer maxSpeed) {
        if (maxSpeed != null) {
            return pokemon1.hp.loe(maxSpeed);
        }
        return null;
    }
}
