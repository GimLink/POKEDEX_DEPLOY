package Link.pokemon.domain.pokemon;

import lombok.Data;

@Data
public class PokemonSearchCond {

    private String pokemonName;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

    public PokemonSearchCond() {}

    public PokemonSearchCond(String pokemonName, Integer hp, Integer attack,
                             Integer defense, Integer specialAttack, Integer specialDefense, Integer speed) {
        this.pokemonName = pokemonName;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
}
