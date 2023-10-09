package study.ms.web.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.ms.domain.member.Member;
import study.ms.domain.shop.Shop;
import study.ms.domain.shop.ShopService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;
    
    //reservation 에서 이용하기 위해 만든 매핑    
    @RequestMapping("/{idx}")
    public String getShopIdx(@PathVariable Integer idx, Model model) {
        Shop shop = shopService.getShop(idx);
        model.addAttribute("shop", shop);
        return "reservation/save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveForm() {
        return "shop/save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Shop shop, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        shop.setMemberIdx(member.getIdx());
        shopService.save(shop);
        return "redirect:/shop/save";
    }

}
