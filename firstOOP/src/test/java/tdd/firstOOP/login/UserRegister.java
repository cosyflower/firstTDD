package tdd.firstOOP.login;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker,
                        UserRepository userRepository,
                        EmailNotifier emailNotifier) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if(user != null) { // id로 검색 시 존재하는 회원인 경우를 말하는 상황이 되겠다
            throw new DupIdException();
        }

        // 상수를 활용해서 해결한 Case - 상수 활요
        // userRepository.save(new User("id", "pw", "email"));
        // parameter 를 활용해서 해결한 Case - 일반화
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }

}
