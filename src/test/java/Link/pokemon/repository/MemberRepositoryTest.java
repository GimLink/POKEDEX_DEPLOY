package Link.pokemon.repository;

import Link.pokemon.domain.member.Member;
import Link.pokemon.repository.member.MemberRepositoryV2;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepositoryV2 repository;

    @Test
    void findByLoginId() {
        Member member = repository.findByLoginId("admin").get();
        log.info("name = {}", member.getId());
        assertThat(member.getName()).isEqualTo("admin");
    }
}
