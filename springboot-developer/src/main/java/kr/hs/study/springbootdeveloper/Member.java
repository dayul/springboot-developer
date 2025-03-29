package kr.hs.study.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)      // 기본 생성자 생성
@AllArgsConstructor
@Getter
@Entity(name = "member")     // 엔티티로 지정, 클래스와 테이블을 매핑 (이름 지정 가능)
@Table(name = "member")
public class Member {
    @Id     // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 자동으로 기본키 1씩 증가(auto increment)
    @Column(name = "id", updatable = false)
    public Long id;        // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name", nullable = false)                // name이라는 not null 컬럼과 매핑
    private String name;    // DB 테이블의 'name' 컬럼과 매칭

}
