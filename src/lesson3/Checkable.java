package lesson3;

public interface Checkable {

  //проверять можно капчу, смс, пуш уведомление или код с почты, у нас проверяется капча
  void check2FA();

  String wrongAnswer();
}
