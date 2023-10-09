package study.ms.domain.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import study.ms.domain.member.Member;
import study.ms.domain.member.MemberRepository;
import study.ms.domain.shop.Shop;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findByMemberIdx(Integer memberIdx);



}
