package Link.pokemon.service.MemberService;

import Link.pokemon.domain.member.Member;

import java.util.Optional;

public interface MemberServiceInterface {

    Optional<Member> findById(Long id);

    Optional<Member> findByLoginId(String loginId);
}
