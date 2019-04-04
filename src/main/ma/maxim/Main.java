package main.ma.maxim;


import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        var userCrud = new UserCrud(new Crud());

        // 1) create a java calendar instance
        Calendar calendar = Calendar.getInstance();

        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        java.util.Date now = calendar.getTime();

        // 3) a java current time (now) instance
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());


        // var user = new User(99,"Hello",true,currentTimestamp);

        var getUser = userCrud.getUserById(99);

        // userCrud.storeUser(user);


//        i.findUserById(1);

//        var loginModel = new LoginModel();
//        // var view = new OptionPanelView();
//        var view = new ConsoleView();
//        // var view = new JFrameView();ÎÎ
//
//        var presenter = new Presenter(view,loginModÎel);
//        view.setPresenter(presenter);
//        presenter.run();

    }

}
