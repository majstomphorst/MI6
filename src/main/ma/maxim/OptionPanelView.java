//package main.ma.maxim;
//
//import javax.swing.*;
//import java.util.ArrayList;
//
//
//public class OptionPanelView implements IView {
//
//    private Presenter presenter;
//    private State state;
//
//    public OptionPanelView() {
//        state = State.STATE_WELCOME;
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
//    public void updateView() {
//
//            switch (state) {
//                case STATE_WELCOME:
//                    displayMessage("MI6","Welcome","Agent");
//                    state = State.STATE_MENU;
//                    updateView();
//                    break;
//
//                case STATE_MENU:
//                    state = showMenu();
//                    updateView();
//                    break;
//
//                case STATE_LOGIN_FAILED:
//                    displayMessage("Login Failed","Please try it again.","");
//
//                case STATE_LOGIN:
//                    var userNumber = showLogin();
//                    presenter.validateLogin(userNumber);
//                    break;
//
//                case STATE_SECRET:
//                    var secretLine = showSecretLine();
//                    presenter.validateSecretLine(secretLine);
//                    break;
//
//                case STATE_SECRET_FAILED:
//                    displayMessage("Secret Line Failed",
//                            "You cant login anymore","until the system reboots");
//                    state = State.STATE_MENU;
//                    updateView();
//                    break;
//
//                case STATE_ACCESS_GRANTED:
//                    Integer id = presenter.getInfo();
//                    showLognedInMenu(ServiceNumberHelper.getUserName(id));
//                    break;
//
//                case STATE_EXIT:
//                    presenter.exit();
//                    break;
//
//            }
//    }
//
//    private String showSecretLine() {
//        String userString = JOptionPane.showInputDialog(
//                null,
//                "Enter the secret line",
//                "SecretLine",
//                JOptionPane.WARNING_MESSAGE
//        );
//        return userString;
//    }
//
//    private State showLognedInMenu(String agentNumber) {
//        var optionList = new ArrayList<String>();
//        optionList.add("Logout");
//
//        Object[] options = optionList.toArray();
//
//        int value = JOptionPane.showOptionDialog(
//                null,
//                agentNumber + " select an option:",
//                "LogedIn Menu",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                optionList.get(0)
//        );
//
//        switch (optionList.get(value)) {
//            case "Logout":
//                return State.STATE_EXIT;
//            default:
//                return State.STATE_MENU;
//
//        }
//
//    }
//
//    private State showMenu() {
//
//        var optionList = new ArrayList<String>();
//        optionList.add("Login");
//        optionList.add("Cancel");
//
//        Object[] options = optionList.toArray();
//
//        int value = JOptionPane.showOptionDialog(
//                null,
//                "Agent select an option:",
//                "Menu",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                optionList.get(0)
//        );
//
//        switch (optionList.get(value)) {
//            case "Login":
//                return State.STATE_LOGIN;
//            case "Cancel":
//                return State.STATE_EXIT;
//            default:
//                return State.STATE_MENU;
//
//        }
//    }
//
//    private Integer showLogin() {
//        Integer userNumber = 0;
//
//        String userString = JOptionPane.showInputDialog(
//                null,
//                "Enter you agent number:",
//                "Login",
//                JOptionPane.QUESTION_MESSAGE
//        );
//
//        try {
//            userNumber = Integer.parseInt(userString);
//        } catch (NumberFormatException e) {
//            return userNumber;
//        } finally {
//            return userNumber;
//        }
//    }
//
//
//    private void displayMessage(String title, String lineOne, String lineTwo) {
//        JOptionPane.showMessageDialog(
//                null,
//                lineOne + "\n"+ lineTwo,
//                title,
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//}
