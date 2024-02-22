package Link.pokemon.service.MemberService;

import Link.pokemon.domain.member.Member;
import Link.pokemon.repository.member.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberServiceInterface{

    private final MemberRepositoryV2 repository;

    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return repository.findByLoginId(loginId);
    }
}
