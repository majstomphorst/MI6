package main.ma.maxim;


public class Main {

    public static void main(String[] args) {
        var loginModel = new LoginModel();

        var view = new OptionPanelView();
        var presenter = new Presenter(view,loginModel);
        view.setPresenter(presenter);
        presenter.run();



//        var console = new ConsoleView(loginModel);
//        console.run();
    }

}
