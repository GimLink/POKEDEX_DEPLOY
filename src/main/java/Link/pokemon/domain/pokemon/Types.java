package Link.pokemon.domain.pokemon;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Types {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer IDType;

    private String type;


    public Types() {

    }
}
