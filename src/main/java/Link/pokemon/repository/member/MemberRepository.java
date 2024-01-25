package Link.pokemon.repository.member;

import Link.pokemon.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
@Transactional
public class MemberRepository implements MemberRepositoryInterface{

    private final SpringDataJpaMemberRepository repository;
    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }
}
