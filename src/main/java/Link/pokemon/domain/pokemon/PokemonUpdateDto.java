package Link.pokemon.domain.pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PokemonUpdateDto {

    private Long idPokemon;
    private String pokemonName;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

    private List<Types> types = new ArrayList<>();

    public PokemonUpdateDto() {
    }

    public PokemonUpdateDto(Long idPokemon, String pokemonName, Integer hp, Integer attack,
                            Integer defense, Integer specialAttack, Integer specialDefense, Integer speed, List<Types> types) {
        this.idPokemon = idPokemon;
        this.pokemonName = pokemonName;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.types = types;
    }

}
