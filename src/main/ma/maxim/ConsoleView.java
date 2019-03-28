//package main.ma.maxim;
//
//import java.util.Scanner;
//
//public class ConsoleView {
//
//    LoginModel loginManager;
//    Scanner in;
//
//    public ConsoleView(LoginModel manager) {
//        loginManager = manager;
//        in = new Scanner(System.in);
//    }
//
//
//    public void run() {
//        int value = 0;
//        showWelcome();
//
//        while (!loginManager.isLoggedIn()) {
//
//            showStatus();
//
//            try {
//                System.out.print("What is you service number?:");
//                value = Integer.parseInt(in.nextLine());
//
//            } catch (NumberFormatException e) {
//                System.out.println("That is NOT a number!");
//                continue;
//            }
//
//            if (!loginManager.isValid(value)) {
//                continue;
//            }
//
//            System.out.print("What is the secrete line: ");
//            String line = in.nextLine();
//
//            if (!loginManager.validateSecretLine(line)) {
//                continue;
//            }
//
//
//        }
//
//        if (loginManager.isLoggedIn()) {
//            System.out.println("YAY");
//            showStatus();
//        }
//
//    }
//
//    public void showStatus() {
//        System.out.println("=========Satus=========");
//        System.out.println(String.format("%-10s %s", "Welcome",ServiceNumberHelper.getUserName(loginManager.getId())));
//        System.out.println(String.format("%-10s %s", "Logged in",String.valueOf(loginManager.isLoggedIn())));
//        System.out.println("=======================");
//
//        if (loginManager.isLoggedIn()) {
//            showUserStatus();
//        }
//
//    }
//    public void showUserStatus() {
//        System.out.println("=========Agent=========");
//
//
//    }
//
//    private void showWelcome() {
//        System.out.println(String.format("%-20s","WELCOME"));
//    }
//
//
//}
