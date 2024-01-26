package Link.pokemon;

import Link.pokemon.domain.member.Member;
import Link.pokemon.repository.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init(){
        Member member = new Member();
        member.setLoginId("admin");
        member.setPassword("1q2w3e4r");
        member.setName("admin");

        memberRepository.save(member);
    }
}
