package Link.pokemon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Types {

    @Id
    private Integer IDType;

    private String type;

    public Types() {

    }
}
