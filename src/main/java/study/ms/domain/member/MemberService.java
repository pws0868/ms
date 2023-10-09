package study.ms.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMember(Integer idx) {
        return memberRepository.findByIdx(idx).orElse(new Member());
    }


    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member login(UserLogin userLogin) {
        return memberRepository.findByIdAndPassword(userLogin.getId(), userLogin.getPassword()).orElse(new Member());
    }

}
