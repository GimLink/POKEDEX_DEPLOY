package Link.pokemon.domain.pokemon;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTypes is a Querydsl query type for Types
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTypes extends EntityPathBase<Types> {

    private static final long serialVersionUID = -1149576349L;

    public static final QTypes types = new QTypes("types");

    public final NumberPath<Integer> IDType = createNumber("IDType", Integer.class);

    public final ListPath<Pokemon, QPokemon> pokemons = this.<Pokemon, QPokemon>createList("pokemons", Pokemon.class, QPokemon.class, PathInits.DIRECT2);

    public final StringPath type = createString("type");

    public QTypes(String variable) {
        super(Types.class, forVariable(variable));
    }

    public QTypes(Path<? extends Types> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTypes(PathMetadata metadata) {
        super(Types.class, metadata);
    }

}

