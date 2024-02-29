package lesson4;

public class UserRegistration {

  public static boolean registerUser(String login, String password, String confirmPassword) {

    try {
      if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
        throw new WrongLoginException("WrongLoginException");
      }
      if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
        throw new WrongPasswordException("WrongPasswordException");
      }
    } catch (WrongLoginException | WrongPasswordException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  public static class WrongLoginException extends Exception {
    public WrongLoginException() {
      super();
    }

    public WrongLoginException(String message) {
      super(message);
    }
  }

  public static class WrongPasswordException extends Exception {
    public WrongPasswordException() {
      super();
    }

    public WrongPasswordException(String message) {
      super(message);
    }
  }
}
