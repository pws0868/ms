package study.ms.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import study.ms.domain.member.Member;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Optional<Review> findByMemberIdx(Integer idx);
}
