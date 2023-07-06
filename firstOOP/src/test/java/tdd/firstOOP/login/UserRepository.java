package tdd.firstOOP.login;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}
