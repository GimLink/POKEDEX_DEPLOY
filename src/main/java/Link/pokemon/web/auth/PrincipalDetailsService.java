package Link.pokemon.web.auth;

import Link.pokemon.domain.member.Member;
import Link.pokemon.repository.member.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepositoryV2 memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        log.info("loginId = {}", loginId);

        Member memberEntity = memberRepository.findByLoginId(loginId).orElseThrow(() -> {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다. :" + loginId);
        });
        log.info("member = {}", memberEntity);

        return new PrincipalDetails(memberEntity);
    }
}
