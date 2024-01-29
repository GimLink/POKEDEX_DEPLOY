package Link.pokemon.domain.pokemon;

import lombok.Data;

@Data
public class PokemonSearchCond {

    private String pokemon;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

    public PokemonSearchCond() {}

    public PokemonSearchCond(Integer hp, Integer attack,
                             Integer defense, Integer specialAttack, Integer specialDefense, Integer speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
}
