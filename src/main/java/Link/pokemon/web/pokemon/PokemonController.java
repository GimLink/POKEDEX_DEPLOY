package Link.pokemon.web.pokemon;

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
    public String addPokemonV2(@Validated @ModelAttribute Pokemon pokemon,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {

        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "addForm";
        }

        pokemonService.save(pokemon);


        redirect.addAttribute("idPokemon", pokemon.getIdPokemon());
        redirect.addAttribute("status", true);

        return "redirect:/pokemons/{idPokemon}";
    }

    @GetMapping("/{idPokemon}/edit")
    public String editForm(@PathVariable Long idPokemon, Model model) {
        Pokemon pokemon = pokemonService.findById(idPokemon).get();
        model.addAttribute("pokemon", pokemon);


//        타임리프 사용해서 이런식으로 안해도 기존 타입 체크돼있게 변경

//        if (typeIds != null) {
//            for (Long typeId : typeIds) {
//                Types existingType = typeService.findById(typeId).get();
//                if (existingType != null) {
//                    updatePokemon.addTypes(existingType);
//                }
//            }
//        }

        return "editForm";
    }

    @PostMapping("/{idPokemon}/edit")
    public String edit(@Validated @ModelAttribute Pokemon pokemon, BindingResult bindingResult,
                       @PathVariable Long idPokemon) {

        log.info("pokemon = {}", pokemon);
        log.info("errors = {}", bindingResult);

        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "editForm";
        }


        //updateDto를 쓰려고 억지로 넣는 느낌 Dto 객체 없애버리고 그냥 Pokemon 객체로 해도 되지 않나 싶기도
        PokemonUpdateDto update = new PokemonUpdateDto(pokemon.getIdPokemon(), pokemon.getPokemonName(), pokemon.getHp(),
                pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense(),
                pokemon.getSpeed(), pokemon.getTypes());

        log.info("update = {}", update);


        pokemonService.update(idPokemon, update);


        return "redirect:/pokemons/{idPokemon}";
    }
}
