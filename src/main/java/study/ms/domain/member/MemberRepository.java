package study.ms.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByIdx(Integer idx);

    Optional<Member> findById(String id);

    Optional<Member> findByIdAndPassword(String id, String password);


}
