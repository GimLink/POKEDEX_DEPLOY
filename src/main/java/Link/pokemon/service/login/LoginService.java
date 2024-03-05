package Link.pokemon.service.login;

import Link.pokemon.domain.member.Member;
import Link.pokemon.repository.member.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepositoryV2 repository;

    public Member login(String loginId, String password) {
        return repository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
