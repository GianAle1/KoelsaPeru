package com.mycompany.mavenproject;
import View.LoginView;
public class Mavenproject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
}
