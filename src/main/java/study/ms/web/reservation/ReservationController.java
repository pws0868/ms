package study.ms.web.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.ms.domain.member.Member;
import study.ms.domain.member.MemberRepository;
import study.ms.domain.member.MemberService;
import study.ms.domain.reservation.Reservation;
import study.ms.domain.reservation.ReservationRepository;
import study.ms.domain.reservation.ReservationService;
import study.ms.domain.shop.Shop;
import study.ms.domain.shop.ShopService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final MemberRepository memberRepository;
    private  final ReservationService reservationService;
    private final MemberService memberService;
    private final ShopService shopService;

    private final ReservationRepository reservationRepository;

    //예약 저장시 유저 idx를 저장
    @RequestMapping("/save")
    public String getMemberAndShop(HttpSession session, Model model)
    {
        List<Shop> shop = shopService.getShops();
        Member member = (Member) session.getAttribute("member");

        model.addAttribute("shops", shop);
        model.addAttribute("member", member);
        return "reservation/save";
    }

    @RequestMapping("/list")
    public String list(HttpSession session, Model model)
    {
        List<Shop> shops = shopService.getShops();
        Member member = (Member) session.getAttribute("member");

        model.addAttribute("shops", shops);
        model.addAttribute("member", member);
        return "/reservation/list";
    }

    //유저가 해당 가게를 눌렀을때 예약페이지로 이동
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveForm() {
        return "reservation/save";
    }


    //예약버튼 눌렀을때 db로 데이터 전송
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @RequestParam("createDatetime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime createDatetime,
            @RequestParam("shopIdx") Integer shopIdx,
            @RequestParam("memberIdx") Integer userIdx,
            @RequestParam("status") String status,
            HttpSession session) {

        reservationService.createReservation(createDatetime, shopIdx, userIdx, status);

        return "redirect:/reservation/save";
    }


}
