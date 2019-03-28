package main.ma.maxim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        var loginManager = new Login();
        var console = new ConsoleInterface(loginManager);
        console.run();
    }

}
