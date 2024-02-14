package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.util.StringUtils;

import java.util.List;

import static Link.pokemon.domain.pokemon.QPokemon.pokemon1;

public class PokemonQueryRepository {

    private final JPAQueryFactory query;

    public PokemonQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Pokemon> findAll(PokemonSearchCond cond) {

        String pokemon = cond.getPokemon();
        Integer hp = cond.getHp();
        Integer attack = cond.getAttack();
        Integer defense = cond.getDefense();
        Integer specialAttack = cond.getSpecialAttack();
        Integer specialDefense = cond.getSpecialDefense();
        Integer speed = cond.getSpeed();

        return query
                .select(pokemon1)
                .from(pokemon1)
                .where(likePokemonName(pokemon), maxHp(hp), maxAttack(attack), maxDefense(defense), maxSattack(specialAttack),
                        maxSdefense(specialDefense), maxSpeed(speed))
                .fetch();

    }

    private BooleanExpression likePokemonName(String pokemon) {
        if (StringUtils.hasText(pokemon)) {
            return pokemon1.pokemon.like("%" + pokemon + "%");
        }
        return null;
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
