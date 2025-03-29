import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다.")     // 테스트 이름
    @Test       // 테스트 메서드
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        // 가독성 향상
        assertThat(a + b).isEqualTo(sum);    // 값이 같은지 확인
    }

    // 실패 테스트 예시 : 테스트 케이스가 하나라도 실패하면 전체 테스트를 실패한 것으로 알려줌
//    @DisplayName("1 + 3은 4이다.")
//    @Test
//    public void junitFailedTest() {
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(a + b, sum);
//    }
}
