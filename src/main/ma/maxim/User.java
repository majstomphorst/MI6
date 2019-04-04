package main.ma.maxim;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    public Integer id;
    @ColumnName("password")
    public String secret;
    public Boolean active;
    public Timestamp licence;


    public User(Integer id, String secret,Boolean active,Timestamp licence) {
        this.id = id;
        this.secret = secret;
        this.active = active;
        this.licence = licence;
    }

    public User() {

    }
}
