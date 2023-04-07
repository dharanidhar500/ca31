package org.example;


import java.util.ResourceBundle;

public class App {
    public boolean login_test(String uname, String pass) {

        ResourceBundle r = ResourceBundle.getBundle("Config");
        String username = r.getString("username");
        String password = r.getString("password");

        if (username.equals(uname) && password.equals(pass)) {
            return true;
        } else

            return false;

    }
}