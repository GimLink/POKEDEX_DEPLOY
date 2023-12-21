package Link.pokemon.domain.pokemon;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

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
