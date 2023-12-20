package Link.pokemon.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RelPokemonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Rel_Pokemon_Type")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Pokemon")
    private Pokemon pokemon;

    @ManyToOne
    @JoinColumn(name = "ID_Type")
    private Types type;

    public RelPokemonType() {

    }
}
