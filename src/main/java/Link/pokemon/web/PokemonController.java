package Link.pokemon.web;

import Link.pokemon.domain.pokemon.Pokemon;
import Link.pokemon.domain.pokemon.PokemonSearchCond;
import Link.pokemon.domain.pokemon.PokemonUpdateDto;
import Link.pokemon.domain.pokemon.Types;
import Link.pokemon.service.pokemon.PokemonServiceV2;
import Link.pokemon.service.type.TypeServiceInter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonServiceV2 pokemonService;
    private final TypeServiceInter typeService;

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

    @GetMapping("/add")
    public String addForm(@ModelAttribute Pokemon pokemon) {return "addForm";}

//    @PostMapping("/add")
    public String addPokemon(@RequestParam Long idPokemon, @RequestParam String pokemon, @RequestParam Integer hp,
                             @RequestParam Integer attack, @RequestParam Integer defense, @RequestParam Integer specialAttack,
                             @RequestParam Integer specialDefense, @RequestParam Integer speed,
                             @RequestParam(name = "typeIds", required = false) Long[] typeIds,
                             Model model,
                             RedirectAttributes redirect) {
        Pokemon addPokemon = new Pokemon(idPokemon, pokemon, hp, attack, defense, specialAttack, specialDefense, speed);

        if (typeIds != null) {
            for (Long typeId : typeIds) {
                Types existingType = typeService.findById(typeId).get();
                if (existingType != null) {
                    addPokemon.addTypes(existingType);
                }
            }
        }

        try {
            pokemonService.save(addPokemon);
        } catch (Exception e) {
            log.info("error = {}", e);
        }


        model.addAttribute("pokemon", addPokemon);
        redirect.addAttribute("idPokemon", addPokemon.getIdPokemon());
        redirect.addAttribute("status", true);
        return "redirect:/pokemons/{idPokemon}";
    }

    @PostMapping("/add")
//    ModelAttribute 사용하면 Pokemon객체가 자동으로 pokemon으로 바인딩 돼서 포켓몬 이름을 필드인 pokemon과 충돌 typemismatch 에러 발생
    public String addPokemonV2(@Validated @ModelAttribute Pokemon pokemon,
                             BindingResult bindingResult,
                             @RequestParam(name = "typeIds", required = false) Long[] typeIds,
                             RedirectAttributes redirect) {

        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "addForm";
        }

        if (typeIds != null) {
            for (Long typeId : typeIds) {
                Types existingType = typeService.findById(typeId).get();
                if (existingType != null) {
                    pokemon.addTypes(existingType);
                }
            }
        }


        pokemonService.save(pokemon);

        return "redirect:/pokemons/{idPokemon}";
    }

    @GetMapping("/{idPokemon}/edit")
    public String editForm(@PathVariable Long idPokemon, Model model) {
        Pokemon pokemon = pokemonService.findById(idPokemon).get();
        model.addAttribute("pokemon", pokemon);
        int i = 1;

        if (pokemon.getTypes().size() >= 2) {
            for (Types type : pokemon.getTypes()) {
                if (i == 1) {
                    model.addAttribute("type1", type);
                } else {
                    model.addAttribute("type2", type);
                }
                i++;
            }
        } else {
            Types nullType = new Types();
            model.addAttribute("type1", pokemon.getTypes().get(0));
            model.addAttribute("type2", nullType);
        }

        return "/editForm";
    }

    @PostMapping("/{idPokemon}/edit")
    public String edit(@Validated @ModelAttribute PokemonUpdateDto update, BindingResult bindingResult,
                       @PathVariable Long idPokemon,
                       @RequestParam(name = "typeIds", required = false) Long[] typeIds) {

        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "/editForm";
        }

        Pokemon updatePokemon = pokemonService.findById(idPokemon).get();

        if (typeIds != null) {
            for (Long typeId : typeIds) {
                Types existingType = typeService.findById(typeId).get();
                if (existingType != null) {
                    updatePokemon.addTypes(existingType);
                }
            }
        }

        pokemonService.update(idPokemon, update);

        return "redirect:/pokemons/{idPokemon}";
    }
}
