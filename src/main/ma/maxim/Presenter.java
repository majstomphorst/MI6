package main.ma.maxim;

public class Presenter {

    private OptionPanelView view;
    private LoginModel model;

    public Presenter(OptionPanelView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }


    public void run() {
        view.updateView();
    }

    public void exit() {
        System.exit(0);
    }

    public void validateLogin(Integer number) {
        if (model.isValid(number)) {
            view.setState(State.STATE_SECRET);
        } else {
            view.setState(State.STATE_LOGIN_FAILED);
        }
        view.updateView();
    }

    public void validateSecretLine(String line) {
         if (model.validateSecretLine(line)) {
             view.setState(State.STATE_ACCESS_GRANTED);
         } else {
             view.setState(State.STATE_SECRET_FAILED);
         }
         view.updateView();
    }

    public Integer getInfo() {
        return model.getId();
    }

}