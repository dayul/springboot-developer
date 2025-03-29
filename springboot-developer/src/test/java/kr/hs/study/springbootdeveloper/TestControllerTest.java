package kr.hs.study.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest         // 테스트용 Application context 생성 (SpringBootApplication에 포함된 빈을 찾아 생성)
@AutoConfigureMockMvc   // MockMvc 생성, 자동으로 구성 (컨트롤러 테스트 시 사용되는 클래스)
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach     // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                       .build();
    }

    @AfterEach      // 테스트 실행 후 실행하는 메서드
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    // 로직 테스트
    @DisplayName("getAllMembers : 아티클 조회에 성공함")
    @Test
    public void getAllMembers() throws Exception {
        // given(테스트 준비) : 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "추다율"));

        // when(테스트 진행) : 리스트 조회 API 호출
        final ResultActions result = mockMvc.perform(get(url)   // perform() : 요청을 전송하는 메서드
                                    .accept(MediaType.APPLICATION_JSON));   // accept() : 무슨 타입으로 응답 받을지 명시

        // then(테스트 결과 검증) : 응답 코드가 200인지, 반환 값이 저장된 값과 같은지 확인
        result
                .andExpect(status().isOk())     // andExpect() : 응답 검증
                // 응답의 0번째 값이 DB에서 저장한 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))  // jsonPath() : 응답의 값을 가져옴
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }

}