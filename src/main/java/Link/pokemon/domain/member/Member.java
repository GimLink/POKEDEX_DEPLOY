package Link.pokemon.domain.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 10, message = "로그인 아이디는 최소 2자리에서 최대 10자리 입니다.")
    private String loginId;

    @NotBlank
    @Size(min = 2, max = 10, message = "사용자 이름은 최소 2자리에서 최대 10자리 입니다.")
    private String name;

    @NotBlank
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자리에서 최대 20자리 입니다.")
    private String password;
}
