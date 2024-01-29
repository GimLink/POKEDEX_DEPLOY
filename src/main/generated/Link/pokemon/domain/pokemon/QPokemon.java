package Link.pokemon.domain.pokemon;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPokemon is a Querydsl query type for Pokemon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPokemon extends EntityPathBase<Pokemon> {

    private static final long serialVersionUID = -482235075L;

    public static final QPokemon pokemon1 = new QPokemon("pokemon1");

    public final NumberPath<Integer> attack = createNumber("attack", Integer.class);

    public final NumberPath<Integer> defense = createNumber("defense", Integer.class);

    public final NumberPath<Integer> hp = createNumber("hp", Integer.class);

    public final NumberPath<Long> idPokemon = createNumber("idPokemon", Long.class);

    public final StringPath pokemon = createString("pokemon");

    public final NumberPath<Integer> specialAttack = createNumber("specialAttack", Integer.class);

    public final NumberPath<Integer> specialDefense = createNumber("specialDefense", Integer.class);

    public final NumberPath<Integer> speed = createNumber("speed", Integer.class);

    public QPokemon(String variable) {
        super(Pokemon.class, forVariable(variable));
    }

    public QPokemon(Path<? extends Pokemon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPokemon(PathMetadata metadata) {
        super(Pokemon.class, metadata);
    }

}

