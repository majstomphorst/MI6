package main.ma.maxim;

import java.util.ArrayList;
import java.util.List;

public class LoginModel {
    private String secret;
    private Integer id;
    private Boolean loginState;

    private IUserCrud userCrud;

    public LoginModel(IUserCrud userCrud) {
        this.userCrud = userCrud;
        secret = "For ThE Royal QUEEN";
        loginState = false;
    }

    public Integer getId() {
        return id;
    }

    public Boolean login(Integer number, String password) {

        // is user on blacklist
        if (isInBlackList(number)) {
            return false;
        }

       var user = userCrud.getUserById(number);
       if (user == null) {
           var newUser = new User(number);
           userCrud.storeUser(newUser);
           user = newUser;
       }

       // check is user is active
        if (user.active) {
            return false;
        }

       // check if password is valid
        if(!user.password.equals(password)) {
            // blacklist the agent
        }

        // create record for user login

       return true;
    }

    public boolean isLoggedIn() {
        return loginState;
    }

//    public boolean validateSecretLine(String input) {
//        if (input.equals(secret)) {
//            loginState = true;
//            return true;
//        }
//        blackList.add(id);
//        return false;
//    }



    public boolean isValidNumber(int number) {
        if (number > 0 && number <= 999) {
            return true;
        }
        return false;
    }

    private boolean isInBlackList(Integer number){
            userCrud.

        return true;
    }

}
