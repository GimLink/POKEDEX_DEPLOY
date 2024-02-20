package Link.pokemon.domain.pokemon;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pokemon {

    @Id
    private Long idPokemon;

    private String pokemon;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

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

    public Pokemon(Long idPokemon, String pokemon, Integer hp, Integer attack, Integer defense, Integer specialAttack,
                   Integer specialDefense, Integer speed) {
        this.idPokemon = idPokemon;
        this.pokemon = pokemon;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
}
