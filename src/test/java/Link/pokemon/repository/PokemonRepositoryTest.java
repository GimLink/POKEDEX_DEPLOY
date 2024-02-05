package Link.pokemon.repository;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.Types;
import Link.pokemon.repository.Types.TypeRepository;
import Link.pokemon.repository.pokemon.PokemonQueryRepository;
import Link.pokemon.repository.pokemon.PokemonRepository;
import Link.pokemon.repository.pokemon.PokemonRepositoryV2;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class PokemonRepositoryTest {

    @Autowired
    PokemonRepositoryV2 repository;
    @Autowired
    PokemonQueryRepository query;
    @Autowired
    TypeRepository typeRepository;

    @Test
    void findById() {
//        Pokemon testPokemon = new Pokemon(200L,"test", 1, 1, 1, 1, 1, 1);
        Pokemon pokemon = repository.findById(1L).get();
        log.info("pokemon = {}", pokemon.getPokemon());

        assertThat(pokemon.getIdPokemon()).isEqualTo(1);
    }

    @Test
    void findAll() {
        PokemonSearchCond cond = new PokemonSearchCond(30, null, null, null,
                null, null);
        List<Pokemon> pokemon = query.findAll(cond);

        log.info("result = {}", pokemon);
    }

    @Test
    void findType() {
        Pokemon pokemon = repository.findById(1L).get();
        List<Types> types = pokemon.getTypes();
        log.info("result = {}", types);

    }

    @Test
    void findPokemonByType() {
        Types type = typeRepository.findById(1L).get();
        log.info("type = {}", type.getType());
    }

    @Test
    void saveAndFind() {
        Pokemon newPokemon = new Pokemon(152L, "aaa", 50, 50, 50, 50, 50, 50);
        Pokemon bulbasar = repository.findById(1L).get();
        Types type = bulbasar.getTypes().get(0);
        log.info("type = {}", type);
        newPokemon.getTypes().add(type);
        repository.save(newPokemon);
        Pokemon findPokemon = repository.findById(152L).get();
        log.info("result = {}", findPokemon);
    }
}