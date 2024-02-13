package Link.pokemon.service.type;

import Link.pokemon.domain.pokemon.Types;

import java.util.Optional;

public interface TypeServiceInter {
    Optional<Types> findById(Long id);

    Optional<Types> findByType(String type);


}
