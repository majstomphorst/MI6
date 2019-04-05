package main.ma.maxim;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

public class User {
    public Integer id;
    public String password;
    public Boolean active;
    public LocalDate licence;

    public User(Integer id, String password,Boolean active,LocalDate licence) {
        this.id = id;
        this.password = password;
        this.active = active;
        this.licence = licence;
    }


    public User() { }
}
