package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaPokeRepository extends JpaRepository<Pokemon, Long> {
}
