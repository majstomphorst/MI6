package main.ma.maxim;

enum LoginState {
    STATE_LOGIN,
    STATE_SECRET,
    STATE_ACCESS_GRANTED,
    STATE_SECRET_FAILED,
    STATE_LOGIN_FAILED,
    STATE_EXIT
}

public class LoginPresenter extends MainPresenter implements IPresenter {

    private LoginState loginState;
    private LoginModel model;

    public LoginPresenter(IView view, ICrud crud) {
        super(view, crud);
        this.model = new LoginModel(new UserCrud(crud));
        this.loginState = LoginState.STATE_LOGIN;
        view.setPresenter(this);
    }

    public void handleLoginRequest() {
        switch (loginState) {
            case STATE_LOGIN:
                view.showLogin();

                break;
            case STATE_LOGIN_FAILED:

                break;
            case STATE_SECRET_FAILED:

                break;
            default:
                System.out.println("default case LOGIN_PRESENTER");
                break;
        }
    }

    @Override
    public void validateLoginForm(Integer number, String secret) {

        // check if the number is valid
        if (!model.isValidNumber(number)) {
            view.showMessage("InvalidNumber","1 t/m 999");
            return;
        }

        // check if user is in db
        if (!model.login(number,secret)){



        }




    }
}
