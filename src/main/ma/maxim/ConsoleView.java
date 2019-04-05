//package main.ma.maxim;
//
//import java.util.Scanner;
//
//public class ConsoleView implements IView{
//
//    private Presenter presenter;
//    private State state;
//    Scanner in;
//
//    public ConsoleView() {
//        state = State.STATE_WELCOME;
//        in = new Scanner(System.in);
//    }
//
//    public void setPresenter(Presenter presenter) {
//        this.presenter = presenter;
//    }
//
//    public void setState(State newState) {
//        state = newState;
//    }
//
//
//    public void updateView() {
//        int value = 0;
//
//        switch (state) {
//            case STATE_WELCOME:
//                displayMessage("MI6",
//                               "Welcome Agent",
//                               "");
//
//                state = State.STATE_MENU;
//                updateView();
//                break;
//
//            case STATE_MENU:
//                state = showMenu();
//                updateView();
//                break;
//
//            case STATE_LOGIN_FAILED:
//                displayMessage("Login Faild",
//                               "",
//                               "");
//
//            case STATE_LOGIN:
//                var userNumber = showLogin();
//                presenter.validateLogin(userNumber);
//                break;
//
//            case STATE_SECRET:
//                var secretLine = showSecretLine();
//                presenter.validateSecretLine(secretLine);
//                break;
//
//            case STATE_SECRET_FAILED:
//                displayMessage("Secret failed",
//                               "You can not login anymore",
//                               "");
//                state = State.STATE_MENU;
//                updateView();
//                break;
//
//            case STATE_ACCESS_GRANTED:
//                Integer id = presenter.getInfo();
//                showLognedInMenu(ServiceNumberHelper.getUserName(id));
//                break;
//
//            case STATE_EXIT:
//                presenter.exit();
//                break;
//        }
//
//
//    }
//
//    private State showLognedInMenu(String userName) {
//        System.out.println("Welcome");
//        System.out.println("====" + userName + "=====");
//        System.out.println("=========Menu=========");
//        System.out.println("Press C to Cancel");
//        System.out.println("=====================");
//
//        String value = in.nextLine();
//
//        switch (value.toUpperCase()) {
//            case "C":
//                return State.STATE_EXIT;
//            default:
//                return State.STATE_MENU;
//        }
//
//    }
//
//
//    private String showSecretLine() {
//        System.out.print("What is the secrete line: ");
//        String line = in.nextLine();
//        return line;
//    }
//
//    private Integer showLogin() {
//        Integer userNumber = 0;
//
//        System.out.print("What is you service number?:");
//        var userInput = in.nextLine();
//
//
//        try {
//            userNumber = Integer.parseInt(userInput);
//        } catch (NumberFormatException e) {
//            return userNumber;
//        } finally {
//            return userNumber;
//        }
//    }
//
//    private State showMenu() {
//        System.out.println("=========Menu=========");
//        System.out.println("Press L to Login");
//        System.out.println("Press C to Cancel");
//        System.out.println("=====================");
//
//        String value = in.nextLine();
//
//        switch (value.toUpperCase()) {
//            case "L":
//                return State.STATE_LOGIN;
//            case "C":
//                return State.STATE_EXIT;
//            default:
//                return State.STATE_MENU;
//        }
//
//    }
//
//    private void displayMessage(String title, String lineOne, String lineTwo) {
//        System.out.println("========="+title+"=========");
//        System.out.println(lineOne);
//        System.out.println(lineTwo);
//        System.out.println("=====================");
//    }
//}
