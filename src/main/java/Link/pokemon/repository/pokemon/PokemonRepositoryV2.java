package Link.pokemon.repository.pokemon;

import Link.pokemon.domain.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepositoryV2 extends JpaRepository<Pokemon, Long> {
}
