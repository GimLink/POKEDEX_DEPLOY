package Link.pokemon.domain.pokemon;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pokemon {

    @Id
    @Range(min = 0, max = 1000)
    private Long idPokemon;

    @NotBlank(message = "이름을 입력해주세요.")
    private String pokemonName;

    @NotNull(message = "체력을 입력해주세요.")
    private Integer hp;
    @NotNull(message = "공격력을 입력해주세요.")
    private Integer attack;
    @NotNull(message = "방어력을 입력해주세요.")
    private Integer defense;
    @NotNull(message = "특수공격력을 입력해주세요.")
    private Integer specialAttack;
    @NotNull(message = "특수방어력을 입력해주세요.")
    private Integer specialDefense;
    @NotNull(message = "속도를 입력해주세요.")
    private Integer speed;

    private String PokemonImageUrl;

    @ManyToMany
    @JoinTable(
            name = "rel_pokemon_type",
            joinColumns = @JoinColumn(name = "ID_POKEMON"),
            inverseJoinColumns = @JoinColumn(name = "ID_TYPE")
    )
    private List<Types> types = new ArrayList<Types>();

    public void addTypes(Types type) {
        if (this.types != null){
            for (Types existType : this.types) {
                existType.getPokemons().remove(this);
            }
            this.types.clear();
        }
        this.types.add(type);
        type.getPokemons().add(this);
    }

    public Pokemon() {

    }

    public Pokemon(Long idPokemon, String pokemonName, Integer hp, Integer attack, Integer defense, Integer specialAttack,
                   Integer specialDefense, Integer speed) {
        this.idPokemon = idPokemon;
        this.pokemonName = pokemonName;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
}
