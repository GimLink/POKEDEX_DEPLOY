package Link.pokemon.web;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.Types;
import Link.pokemon.service.pokemon.PokemonServiceV2;
import Link.pokemon.service.type.TypeService;
import Link.pokemon.service.type.TypeServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonServiceV2 pokemonService;
    private final TypeService typeService;

    @GetMapping
    public String pokemons(@ModelAttribute("pokemonSearch") PokemonSearchCond pokemonSearch, Model model) {
        List<Pokemon> pokemons = pokemonService.findAll(pokemonSearch);
        model.addAttribute("pokemons", pokemons);
        return "pokemons";
    }
    @GetMapping("/{idPokemon}")
    public String pokemon(@PathVariable(name = "idPokemon") Long idPokemon, Model model) {
        Pokemon pokemon = pokemonService.findById(idPokemon).get();
        model.addAttribute("pokemon", pokemon);
        return "pokemon";
    }
    @GetMapping("/type/{type}")
    public String typePokemons(@PathVariable(name = "type") String typeName, Model model) {
        Types type = typeService.findByType(typeName).get();
        model.addAttribute("type", type);
        return "typePokemons";
    }
}
