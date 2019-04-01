package main.ma.maxim;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static main.ma.maxim.State.*;


public class JFrameView implements ViewInterface {

    private Presenter presenter;
    private State state;
    private String information;

    private JFrame JFrame;
    private JPanel panel;
    private JLabel code_label, secret_label, message;
    private JTextField code_field, secret_field;
    private JButton login_button, cancel_button;

    public JFrameView() {
        state = STATE_LOGIN;
    }
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    public void setState(State newState) {
        this.state = newState;
    }

    public void setMessage(String text) {
        if (text == null) {
            information = "";
            return;
        }

        if (information == null) {
            information = "";
        }
        information += text;
    }

    public void updateView() {
        setMessage(null);

        switch (state) {
            case STATE_LOGIN:
                showLogin();
                break;

            case STATE_ACCESS_GRANTED:
                setMessage("ACCESS_GRANTED");
                Integer id = presenter.getInfo();
                showLognedInMenu(ServiceNumberHelper.getUserName(id));
                break;

            case STATE_EXIT:
                presenter.exit();
                break;

            case STATE_LOGIN_FAILED:
                setMessage("user number not valid");

            case STATE_SECRET_FAILED:
                setMessage("secret_faild you cant login any more");

        }
    }

    public void showLogin() {
        JFrame = new JFrame("login");
        // Label
        code_label = new JLabel("Agent code:");
        secret_label = new JLabel("Secret Line:");

        // field
        code_field = new JTextField(20);
        secret_field = new JPasswordField(20);

        // button
        login_button = new JButton("Login");

        // message
        message = new JLabel();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,2,2));

        panel.add(code_label);
        panel.add(code_field);
        panel.add(secret_label);
        panel.add(secret_field);
        panel.add(login_button);

        panel.add(message);

        // set border for the panel
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));


        JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer userNumber = 0;

                String userString = code_field.getText();
                String password = secret_field.getText();

                try {
                    userNumber = Integer.parseInt(userString);
                } catch (NumberFormatException f) { }

                presenter.validateLoginForm(userNumber, password);

                message.setText(information);

                if (state == State.STATE_ACCESS_GRANTED) {
                    updateView();
                }
            }
        };

        // Adding the listeners to components..
        login_button.addActionListener(actionListener);
        JFrame.add(panel);
        JFrame.pack();
        JFrame.setLocationRelativeTo(null);
        JFrame.setVisible(true);
    }

    private void showLognedInMenu(String userName) {
        showMessage("Sucess",userName);
    }

    private void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE);
    }
}