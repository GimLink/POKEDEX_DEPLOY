package Link.pokemon.service.pokemon;

import Link.pokemon.domain.pokemon.*;
import Link.pokemon.repository.pokemon.PokemonQueryRepository;
import Link.pokemon.repository.pokemon.PokemonRepositoryV2;
import Link.pokemon.service.S3.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PokemonServiceV2 implements PokeService{

    private final PokemonRepositoryV2 pokemonRepositoryV2;
    private final PokemonQueryRepository pokemonQueryRepository;
    private final AwsS3Service awsS3Service;


    @Override
    public Pokemon save(MultipartHttpServletRequest mtfRequest, Pokemon pokemon) throws IOException {

        List<MultipartFile> fileList = mtfRequest.getFiles("upload_image");

        if (fileList.size() != 0) {
            for (int i = 0; i < fileList.size(); i++) {
                String originImageName = fileList.get(i).getOriginalFilename();
                String imageName = awsS3Service.createFileName(originImageName);

                String filePath = "images/" + pokemon.getIdPokemon() + imageName;

                String s3ImageUrl = awsS3Service.upload(fileList.get(i), filePath);

                pokemon.setPokemonImageUrl(s3ImageUrl);

            }

        }

        return pokemonRepositoryV2.save(pokemon);
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepositoryV2.findById(id);
    }

    @Override
    public void update(Long pokemonId, PokemonUpdateDto updateParam) {
        Pokemon findPokemon = pokemonRepositoryV2.findById(pokemonId).orElseThrow();

        findPokemon.setIdPokemon(updateParam.getIdPokemon());
        findPokemon.setPokemonName(updateParam.getPokemonName());
        findPokemon.setHp(updateParam.getHp());
        findPokemon.setAttack(updateParam.getAttack());
        findPokemon.setDefense(updateParam.getDefense());
        findPokemon.setSpecialAttack(updateParam.getSpecialAttack());
        findPokemon.setSpecialDefense(updateParam.getSpecialDefense());
        findPokemon.setSpeed(updateParam.getSpeed());

        for (Types type : updateParam.getTypes()) {
            findPokemon.addTypes(type);
        }
    }

    @Override
    public List<Pokemon> findAll(PokemonSearchCond cond) {
        return pokemonQueryRepository.findAll(cond);
    }
}
