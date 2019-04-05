package main.ma.maxim;

import java.util.ArrayList;

public class UserCrud implements IUserCrud {

    private ICrud crud = null;

    public UserCrud(ICrud crud)
    {
        this.crud = crud;
    }

    @Override
    public void storeUser(User user) {

        String sql = "INSERT INTO users (id, password, active, licence) VALUES (?, ?, ?, ?)";

        var userList = new ArrayList<Object>();

        userList.add(user.id);
        userList.add(user.password);
        userList.add(user.active);
        userList.add(user.licence);

        crud.createRow(sql,userList);
    }

    @Override
    public User getUserById(Integer id) {

        String sql = "SELECT * FROM users WHERE id = ?";
        var ids = new ArrayList<Object>();
        ids.add(id);
        return crud.readOneRow(sql,ids,User.class);

    }

    @Override
    public void updateUser(User user) {

    }


}
