package Link.pokemon.repository.member;

import Link.pokemon.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {
}
