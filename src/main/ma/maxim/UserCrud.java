package main.ma.maxim;

import java.util.ArrayList;

public class UserCrud {

    private Crud crud = null;

    public UserCrud(Crud crud)
    {
        this.crud = crud;
    }

    public void storeUser(User user) {
        String sql = "INSERT INTO users (id, password, active, licence) VALUES (?, ?, ?, ?)";

        var userList = new ArrayList<Object>();
        userList.add(user.id);
        userList.add(user.secret);
        userList.add(user.active);
        userList.add(user.licence);


        crud.createRow(sql,userList);
    }

    public User getUserById(Integer id) {

        String sql = "SELECT * FROM users WHERE id = ?";
        var ids = new ArrayList<Object>();
        ids.add(id);
        return crud.readOneRow(sql,ids,User.class);

    }

}
