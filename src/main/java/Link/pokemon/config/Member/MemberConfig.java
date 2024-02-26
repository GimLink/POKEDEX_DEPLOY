package Link.pokemon.config.Member;

import Link.pokemon.repository.member.MemberRepositoryV2;
import Link.pokemon.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberConfig {

    private final MemberRepositoryV2 repository;

    @Bean
    public MemberService memberService() {
        return new MemberService(repository);
    }
}
