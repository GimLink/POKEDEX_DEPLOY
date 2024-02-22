package Link.pokemon.repository.member;

import Link.pokemon.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepositoryV2 extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginId(String loginId);
}
