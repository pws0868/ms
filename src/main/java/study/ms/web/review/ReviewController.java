package study.ms.web.review;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import study.ms.domain.member.Member;
import study.ms.domain.reservation.Reservation;
import study.ms.domain.reservation.ReservationRepository;
import study.ms.domain.reservation.ReservationService;
import study.ms.domain.review.Review;
import study.ms.domain.review.ReviewService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository; // Reservation 엔티티를 다루기 위한 리포지토리


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String saveForm() {
        return "/review/list";
    }

    @RequestMapping(value = "/{memberIdx}", method = RequestMethod.GET)
    public String getReview(@PathVariable Integer memberIdx, Model model) {
        Reservation reservationService1 = reservationService.getMemberIdx(memberIdx);
        model.addAttribute("review", reservationService1);
        return "/review/list";
    }

}

