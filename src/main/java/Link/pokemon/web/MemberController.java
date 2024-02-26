package Link.pokemon.web;

import Link.pokemon.domain.member.Member;
import Link.pokemon.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(Member member) {
        return "/addMemberForm";
    }

    @PostMapping("/add")
    public String addMember(Member newMember) {
        Member addMember = memberService.save(newMember);

        return "redirect:/";
    }
}
