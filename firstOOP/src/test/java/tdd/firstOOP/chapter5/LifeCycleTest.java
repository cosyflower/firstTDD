package tdd.firstOOP.chapter5;

import org.junit.jupiter.api.*;

@DisplayName("테스트 코드 라이프사이클 테스트 진행하기")
public class LifeCycleTest {
    public LifeCycleTest() {
        System.out.println("new LifeCycleTest");
    }

    @Test
    @DisplayName("a를 출력하세요!!")
    @Disabled
    void a(){
        System.out.println("a");
    }

    @Test
    void b(){
        System.out.println("b");
    }

    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown(){
        System.out.println("tearDown");
    }
}
