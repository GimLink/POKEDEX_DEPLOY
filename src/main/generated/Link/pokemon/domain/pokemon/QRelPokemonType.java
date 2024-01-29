package Link.pokemon.domain.pokemon;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRelPokemonType is a Querydsl query type for RelPokemonType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRelPokemonType extends EntityPathBase<RelPokemonType> {

    private static final long serialVersionUID = -1956411222L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRelPokemonType relPokemonType = new QRelPokemonType("relPokemonType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPokemon pokemon;

    public final QTypes type;

    public QRelPokemonType(String variable) {
        this(RelPokemonType.class, forVariable(variable), INITS);
    }

    public QRelPokemonType(Path<? extends RelPokemonType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRelPokemonType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRelPokemonType(PathMetadata metadata, PathInits inits) {
        this(RelPokemonType.class, metadata, inits);
    }

    public QRelPokemonType(Class<? extends RelPokemonType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pokemon = inits.isInitialized("pokemon") ? new QPokemon(forProperty("pokemon")) : null;
        this.type = inits.isInitialized("type") ? new QTypes(forProperty("type")) : null;
    }

}

