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

    @NotBlank
    private String pokemonName;

    @NotNull
    private Integer hp;
    @NotNull
    private Integer attack;
    @NotNull
    private Integer defense;
    @NotNull
    private Integer specialAttack;
    @NotNull
    private Integer specialDefense;
    @NotNull
    private Integer speed;

    private String imageUrl;

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
