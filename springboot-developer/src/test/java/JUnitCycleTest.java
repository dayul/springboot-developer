import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll
    static void beforeAll() {   // 전체 테스트를 실행하기 전, 1회 실행하므로 static으로 선언, DB를 연결하거나 테스트 환경 초기화 시 사용
        System.out.println("@BeforeAll");
    }

    @BeforeEach     // 테스트 케이스를 시작하기 전마다 매번 실행, 메서드에서 사용하는 객체를 초기화하거나 값을 미리 넣을 때 사용
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll
    static void afterAll() {    // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 static으로 선언, DB 연결을 종료할 때나 공통적으로 사용하는 자원을 해제할 때 사용
        System.out.println("@AfterAll");
    }

    @AfterEach      // 테스트 케이스를 종료하기 전마다 매번 실행, 테스트 이후 특정 데이터를 삭제해야 할 때 사용
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
