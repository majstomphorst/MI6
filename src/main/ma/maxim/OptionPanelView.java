package main.ma.maxim;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

enum State {
    STATE_WELCOME,
    STATE_MENU,
    STATE_LOGIN,
    STATE_SECRET,
    STATE_ACCESS_GRANTED,
    STATE_EXIT,
    STATE_SECRET_FAILED,
    STATE_LOGIN_FAILED
}


public class OptionPanelView {

    private Presenter presenter;
    private State state;

    public OptionPanelView() {
        state = State.STATE_WELCOME;
    }

    public void updateView() {
            switch (state) {
                case STATE_WELCOME:
                    displayWelcome();
                    state = State.STATE_MENU;
                    updateView();
                    break;

                case STATE_MENU:
                    state = displayMenu();
                    updateView();
                    break;

                case STATE_LOGIN_FAILED:
                    showLoginFaild();

                case STATE_LOGIN:
                    var userNumber = showLogin();
                    presenter.validateLogin(userNumber);
                    break;

                case STATE_SECRET:
                    var secretLine = showSecretLine();
                    presenter.validateSecretLine(secretLine);
                    break;

                case STATE_SECRET_FAILED:
                    showSecretFailed();
                    break;

                case STATE_ACCESS_GRANTED:
                    System.out.println("STATE_ACCESS_GRANTED");
                    presenter.exit();

                case STATE_EXIT:
                    presenter.exit();
                    break;

            }


    }

    private void showSecretFailed() {
        System.out.println("showSecretFailed");
    }

    private void showLoginFaild() {
        System.out.println("showLoginFailed");
    }

    public void setState(State newState) {
        state = newState;
    }

    private String showSecretLine() {

        String userString = JOptionPane.showInputDialog(
                null,
                "Enter the secret line",
                "SecretLine",
                JOptionPane.WARNING_MESSAGE
        );
        return userString;
    }

    private State displayMenu() {

        var optionList = new ArrayList<String>();
        optionList.add("Login");
        optionList.add("Cancel");

        Object[] options = optionList.toArray();

        int value = JOptionPane.showOptionDialog(
                null,
                "Agent select an option:",
                "Menu",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                optionList.get(0)
        );

        switch (optionList.get(value)) {
            case "Login":
                return State.STATE_LOGIN;
            case "Cancel":
                return State.STATE_EXIT;
            default:
                return State.STATE_MENU;

        }
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private Integer showLogin() {
        Integer userNumber = 0;

        String userString = JOptionPane.showInputDialog(
                null,
                "Enter you agent number:",
                "Login",
                JOptionPane.QUESTION_MESSAGE
        );

        try {
            userNumber = Integer.parseInt(userString);
        } catch (NumberFormatException e) {
            return userNumber;
        } finally {
            return userNumber;
        }
    }

    private void displayWelcome() {

        // prompt the user to enter their name
        JOptionPane.showMessageDialog(
                null,
                "Welcome agent",
                "MI6",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


}