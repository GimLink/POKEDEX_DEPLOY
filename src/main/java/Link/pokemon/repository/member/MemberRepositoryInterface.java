package Link.pokemon.repository.member;

import Link.pokemon.domain.member.Member;

import java.util.Optional;

public interface MemberRepositoryInterface {

    Optional<Member> findById(Long id);

    Member save(Member member);
}
