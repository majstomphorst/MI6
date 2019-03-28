package main.ma.maxim;

import java.util.ArrayList;
import java.util.List;

public class Login {

    private String secret;
    private Integer id;
    private static List<Integer> blackList = new ArrayList<Integer>();

    public Login() {
        secret = "For ThE Royal QUEEN";
    }

    public Integer getId() {
        return id;
    }

    public boolean isLoggedIn() {
        if (id != null) {
            return true;
        }
        return false;
    }

    public boolean validateSecretLine(String input, Integer number) {
        if (input.equals(secret)) {
            id = number;
            return true;
        }
        blackList.add(number);
        return false;
    }

    public boolean isValid(int number) {
        if (isValidNumber(number) && !isInBlackList(number)) {
            return true;
        }
        return false;
    }

    private boolean isValidNumber(int number) {
        if (number > 0 && number <= 999) {
            return true;
        }
        return false;
    }

    private boolean isInBlackList(Integer number) {
        return blackList.contains(number);
    }

}
