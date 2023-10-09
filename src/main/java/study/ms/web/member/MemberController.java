package study.ms.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.ms.domain.member.MemberService;
import study.ms.domain.member.UserLogin;
import study.ms.domain.member.Member;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController
{
    private final MemberService memberService;

    @RequestMapping("/{idx}")
    public String getMember(@PathVariable Integer idx, Model model) {
        Member member = memberService.getMember(idx);
        model.addAttribute("member", member);
        return "member/detail";
    }
    @RequestMapping("/list")
    public String getMembers(Model model) {
        List<Member> members = memberService.getMembers();
        model.addAttribute("members", members);
        return "member/list";
    }
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveForm() {
        return "member/save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Member member) {
        memberService.save(member);
        return "member/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "member/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserLogin userLogin, HttpSession session) {
        Member member = memberService.login(userLogin);

        session.setAttribute("member", member);
        if ("User".equals(member.getType())) {
            return "redirect:/reservation/list";
        }
        if ("Partner".equals(member.getType())) {
            return "redirect:/shop/save";
        }
        return "member/login";
    }

}
