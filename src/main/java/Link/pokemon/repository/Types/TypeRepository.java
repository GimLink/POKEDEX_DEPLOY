package Link.pokemon.repository.Types;

import Link.pokemon.domain.pokemon.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Types, Long> {
}
