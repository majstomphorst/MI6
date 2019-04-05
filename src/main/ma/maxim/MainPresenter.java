package main.ma.maxim;

enum MainState {
    STATE_WELCOME,
    STATE_LOGIN
}

public class MainPresenter {

    IView view;
    private ICrud crud;
    private MainState state;

    public MainPresenter(IView view, ICrud crud) {
        this.view = view;
        this.crud = crud;
        state = MainState.STATE_WELCOME;
    }

    public void handleRequest() {
        switch (state) {
            case STATE_WELCOME:
                view.showMessage("MI6","WELCOME AGENT");
                state = MainState.STATE_LOGIN;
                updateView();
                break;
            case STATE_LOGIN:
                var presenter = new LoginPresenter(view,crud);
                presenter.handleLoginRequest();
                break;

            default:
                    System.out.println("default case MAIN_PRESENTER");
                break;
        }

    }

    private void updateView() {
        handleRequest();
    }
}
