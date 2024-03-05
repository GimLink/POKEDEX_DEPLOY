package Link.pokemon.web;

import Link.pokemon.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name= "loginMember", required = false) Member loginMember, Model model) {

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);

        return "loginHome";

    }
}
