package main.ma.maxim;

public class LoginModel {
    private User user;
    private IUserCrud userCrud;

    public LoginModel(IUserCrud userCrud) {
        this.userCrud = userCrud;
    }

    public Boolean isOnBlacklist(Integer number) {
        var blackList = userCrud.getBlackListEnteryById(number);
        if (blackList != null) {
            return false;
        }
        return true;
    }

    public Boolean doesUserExist(Integer id) {
        this.user = userCrud.getUserById(id);
        if (this.user == null) {
            return false;
        }

        return true;
    }

    public Boolean login(Integer number, String password) {

        if(doesUserExist(number)) {
            return false;
        }

        // is user on blacklist
        if (isOnBlacklist(number)) {
            return false;
        }

        // check is user is active
        if (!user.active) {
            return false;
        }

        // check if password is valid
        if (!user.password.equals(password)) {
            // blacklist the agent
            return false;
        }

        // create record for user login
        userCrud.logAction(number, true);

        return true;
    }

    public boolean isValidNumber(int number) {
        if (number > 0 && number <= 999) {
            return true;
        }
        return false;
    }

}
