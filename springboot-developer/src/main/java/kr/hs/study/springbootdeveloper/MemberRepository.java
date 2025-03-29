package kr.hs.study.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {     // 상속 받을 때 엔티티와 엔티티의 기본키 타입을 넣어줌
}
