package Link.pokemon.repository.Types;

import Link.pokemon.domain.pokemon.Types;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Types, Long> {
    Optional<Types> findByType(String type);
}
