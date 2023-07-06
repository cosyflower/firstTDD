package tdd.firstOOP.login;

public class StubWeakPasswordChecker implements WeakPasswordChecker{
    private Boolean weak = false;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
