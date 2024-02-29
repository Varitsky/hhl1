package lesson4;

import static lesson4.UserRegistration.registerUser;

public class lesson4 {

  public static void main(String[] args) {

    String login = "loginлогин";
    String password = "password";
    String confirmPassword = "password";

    if (registerUser(login, password, confirmPassword)) {
      System.out.println("User is registered");
    } else {
      System.out.println("User registration failed");
    }

    String login2 = "login";
    String password2 = "pass1234";
    String confirmPassword2 = "pass12345";

    if (registerUser(login2, password2, confirmPassword2)) {
      System.out.println("User is registered");
    } else {
      System.out.println("User registration failed");
    }
  }
}