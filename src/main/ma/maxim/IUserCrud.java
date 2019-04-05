package main.ma.maxim;

public interface IUserCrud {
    void storeUser(User user);

    User getUserById(Integer id);

    void updateUser(User user);

    BlackList getBlackListEnteryById(Integer id);

    void logAction(Integer number, Boolean succes);
}
