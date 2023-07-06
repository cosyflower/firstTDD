package tdd.firstOOP.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker =
            new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository =
            new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier =
            new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker,
                fakeRepository,
                spyEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubWeakPasswordChecker.setWeak(true); // 암호가 약하다고 응답하도록 설정 (최대한 간단하게 구현)

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @DisplayName("동일한 Id 존재하면 가입 실패")
    @Test
    void dupIdExits() {
        // 같은 Id 가진 회원이 존재
        fakeRepository.save(new User("id", "pw1", "email@email.com"));
        // 실행 및 결과 입증
        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "pw2", "email");
        });
    }

    @DisplayName("동일한 ID가 존재하지 않으면 가입 성공")
    @Test
    void noDupId_RegisterSuccess() {
        // 임의의 회원 Id 정보 저장하기
//        fakeRepository.save(new User("id", "pw", "email"));
        userRegister.register("id", "pw", "email");
        // 실행 및 결과 입증
        // ID를 통해서 User를 먼저 조회를 한 다음에 ID 그리고 Email을 확인하는 Assertions를 작성한다
        User findUser = fakeRepository.findById("id");
        assertEquals("id", findUser.getId());
        assertEquals("email", findUser.getEmail());
    }

    // 회원 ID를 등록하면
    // 등록한 EMAIL 정보로 회원 가입 완료 라는 이메일이 올바르게 전송되었는지를 확인하는 과정이 되겠다

    @DisplayName("가입하면 메일을 전송합니다")
    @Test
    void whenRegisterThenSendEmail() {
        // 전송이 되었는지
        // 그리고 이메일이 올바른지를 먼저 확인하면 되겠다
        userRegister.register("id", "pw", "email@email.com");
        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@email.com",
                spyEmailNotifier.getEmail());
    }

    @DisplayName("Mockito 활용")
    @Test
    void Mock(){
        User userA = mock(User.class);
        given(userA.toString()).willReturn(String.valueOf(10));

        String str = userA.toString();
        assertEquals("10", str);
    }

    @DisplayName("BDDMockito -> willThrow()")
    @Test
    void MockThrowTest(){
        User userB = mock(User.class);
        given(userB.toString()).willThrow(NullPointerException.class);

        assertThrows(NullPointerException.class,
                () -> {
                    userB.toString();
                });
    }

    @DisplayName("BDDMockito -> willThrow()")
    @Test
    void VoidMethodWillThrowTest(){
        List<String> mockList = mock(List.class);
        willThrow(UnsupportedOperationException.class)
                .given(mockList)
                .clear();

        assertThrows(UnsupportedOperationException.class,
                () -> {
                    mockList.clear();
                });
    }

    @DisplayName("AnyMatchTest")
    @Test
    void AnyMatchTest(){
        User mockUser = mock(User.class);
        given(mockUser.generate(ArgumentMatchers.any())).willReturn("123");

        assertEquals("123", mockUser.generate("1930"));

    }


}
