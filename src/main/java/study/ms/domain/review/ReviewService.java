package study.ms.domain.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.ms.domain.member.Member;
import study.ms.domain.reservation.Reservation;
import study.ms.domain.reservation.ReservationRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReservationRepository reservationRepository;



}
