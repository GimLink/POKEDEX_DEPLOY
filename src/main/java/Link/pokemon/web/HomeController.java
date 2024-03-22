package Link.pokemon.web;

import Link.pokemon.domain.member.Member;
import Link.pokemon.web.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

//    @GetMapping("/")
    public String home(@SessionAttribute(name= "loginMember", required = false) Member loginMember, Model model) {

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);

        return "loginHome";

    }

    @GetMapping("/")
    public String authHome(@AuthenticationPrincipal PrincipalDetails member, Model model) {

        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member.getMember());

        return "loginHome";

    }
}
