package Link.pokemon.repository;

import Link.pokemon.domain.Pokemon;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class PokemonRepositoryTest {

    @Autowired
    PokemonRepository repository;

    @Test
    void findById() {
//        Pokemon testPokemon = new Pokemon(200L,"test", 1, 1, 1, 1, 1, 1);
        Pokemon pokemon = repository.findById(1L).get();

        Assertions.assertThat(pokemon.getIdPokemon()).isEqualTo(1);
    }
}