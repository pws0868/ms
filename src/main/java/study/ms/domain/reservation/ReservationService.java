package study.ms.domain.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.ms.domain.member.Member;
import study.ms.domain.member.MemberRepository;
import study.ms.domain.review.Review;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;


    //reservation에서 입력된 데이터를 저장하기 위한 메서드
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void createReservation(LocalDateTime createDatetime, Integer shopIdx, Integer userIdx, String status) {
        Reservation reservation = new Reservation();
        reservation.setCreateDatetime(createDatetime);
        reservation.setShopIdx(shopIdx);
        reservation.setMemberIdx(userIdx);
        reservation.setStatus(status);
        reservationRepository.save(reservation);
    }

    public Reservation getMemberIdx(Integer memberIdx) {
        return reservationRepository.findByMemberIdx(memberIdx).orElse(new Reservation());
    }




}
