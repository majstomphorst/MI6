package main.ma.maxim;

import java.sql.Timestamp;

public class BlackList {
    public Integer user_id;
    public Timestamp until;

    public BlackList(Integer user_id, Timestamp until) {
        this.user_id = user_id;
        this.until = until;
    }

    public BlackList() { }
}
