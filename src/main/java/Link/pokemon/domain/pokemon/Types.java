package Link.pokemon.domain.pokemon;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString(exclude = "pokemons")
public class Types {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer IDType;

    private String type;

    @ManyToMany(mappedBy = "types")
    private List<Pokemon> pokemons;


    public Types() {

    }
}
