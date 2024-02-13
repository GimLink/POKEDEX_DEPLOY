package Link.pokemon.service.type;

import Link.pokemon.domain.pokemon.Types;
import Link.pokemon.repository.Types.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeService implements TypeServiceInter{

    private final TypeRepository repository;
    @Override
    public Optional<Types> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Types> findByType(String type) {
        return repository.findByType(type);
    }
}
