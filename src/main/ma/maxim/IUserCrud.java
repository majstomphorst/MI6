package main.ma.maxim;

public interface IUserCrud {
    void storeUser(User user);

    User getUserById(Integer id);

    void updateUser(User user);
}
