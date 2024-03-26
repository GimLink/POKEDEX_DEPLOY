package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.util.StringUtils;

import java.util.List;

import static Link.pokemon.domain.pokemon.QPokemon.pokemon;

public class PokemonQueryRepository {

    private final JPAQueryFactory query;

    public PokemonQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Pokemon> findAll(PokemonSearchCond cond) {

        String pokemonName = cond.getPokemonName();
        Integer hp = cond.getHp();
        Integer attack = cond.getAttack();
        Integer defense = cond.getDefense();
        Integer specialAttack = cond.getSpecialAttack();
        Integer specialDefense = cond.getSpecialDefense();
        Integer speed = cond.getSpeed();

        return query
                .select(pokemon)
                .from(pokemon)
                .where(likePokemonName(pokemonName), maxHp(hp), maxAttack(attack), maxDefense(defense), maxSattack(specialAttack),
                        maxSdefense(specialDefense), maxSpeed(speed))
                .fetch();

    }

    private BooleanExpression likePokemonName(String pokemonName) {
        if (StringUtils.hasText(pokemonName)) {
            return pokemon.pokemonName.like("%" + pokemonName + "%");
        }
        return null;
    }

    private BooleanExpression maxHp(Integer maxHp) {
        if (maxHp != null) {
            return pokemon.hp.loe(maxHp);
        }
        return null;
    }

    private BooleanExpression maxAttack(Integer maxAttack) {
        if (maxAttack != null) {
            return pokemon.hp.loe(maxAttack);
        }
        return null;
    }

    private BooleanExpression maxDefense(Integer maxDefense) {
        if (maxDefense != null) {
            return pokemon.hp.loe(maxDefense);
        }
        return null;
    }

    private BooleanExpression maxSattack(Integer maxSattack) {
        if (maxSattack != null) {
            return pokemon.hp.loe(maxSattack);
        }
        return null;
    }

    private BooleanExpression maxSdefense(Integer maxSdefense) {
        if (maxSdefense != null) {
            return pokemon.hp.loe(maxSdefense);
        }
        return null;
    }

    private BooleanExpression maxSpeed(Integer maxSpeed) {
        if (maxSpeed != null) {
            return pokemon.hp.loe(maxSpeed);
        }
        return null;
    }
}
