package main.ma.maxim;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class User {
    public Integer id;
    public String password;
    public Boolean active;
    public Timestamp licence;

    public User(Integer id, String password,Boolean active,Timestamp licence) {
        this.id = id;
        this.password = password;
        this.active = active;
        this.licence = licence;
    }

    public User() {

    }

    public User(Integer id) {
        this.id = id;
        this.password = "abc";
        this.active = true;

        // 1) create a java calendar instance
        Calendar calendar = Calendar.getInstance();

        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        java.util.Date now = calendar.getTime();

        // 3) a java current time (now) instance
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        this.licence = null;

    }
}
