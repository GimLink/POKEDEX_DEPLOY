package Link.pokemon.web.member;

import Link.pokemon.domain.member.Member;
import Link.pokemon.domain.member.Role;
import Link.pokemon.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder encoder;

    @GetMapping("/add")
    public String addForm(@ModelAttribute(name="member") Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String addMember(@Validated Member member, BindingResult bindingResult) {

        if (member.getPassword().length() < 8 || member.getPassword().length() > 20) {
            bindingResult.rejectValue("password", "비밀번호는 최소 8자리에서 최대 20자리 까지입니다.");
        }

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        member.setRole(Role.ROLE_USER);

        member.setPassword(encoder.encode(member.getPassword()));

        Member addMember = memberService.save(member);

        return "redirect:/";
    }
}
