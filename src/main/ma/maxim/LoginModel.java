package main.ma.maxim;

import java.util.ArrayList;
import java.util.List;

public class LoginModel {

    private String secret;
    private Integer id;
    private Boolean loginState;
    private static List<Integer> blackList = new ArrayList<Integer>();

    public LoginModel() {
        secret = "For ThE Royal QUEEN";
        loginState = false;
    }

    public Integer getId() {
        return id;
    }

    public boolean isLoggedIn() {
        return loginState;
    }

    public boolean validateSecretLine(String input) {
        if (input.equals(secret)) {
            loginState = true;
            return true;
        }
        blackList.add(id);
        return false;
    }

    public boolean isValid(int number) {
        if (isValidNumber(number) && !isInBlackList(number)) {
            id = number;
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
