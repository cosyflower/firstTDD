package tdd.firstOOP.chapter7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static tdd.firstOOP.chapter7.CardValidity.INVALID;

public class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();

        // stub류 들을 생성자 인자로 전달하고 있으면서 실질적인 객체가 아니라 가짜 객체를 전달해주고 있다
        //
//        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

//        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
//        RegisterResult result = register.register(req);

//        Assertions.assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("1234567890123456");

//        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
//        RegisterResult result = register.register(req);

//        assertEquals(CardValidity.THEFT, result.getValidity());
    }
}

