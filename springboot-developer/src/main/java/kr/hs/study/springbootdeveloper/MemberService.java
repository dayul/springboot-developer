package kr.hs.study.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void test() {
        // create
        memberRepository.save(new Member(1L, "추다율"));   // save() : 데이터 객체 저장

        // read
        Optional<Member> member = memberRepository.findById(1L);
        List<Member> allMembers = memberRepository.findAll();

        // delete
        memberRepository.deleteById(1L);
    }
}
