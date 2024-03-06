package lesson3;

public class lesson3 {

  public static void main(String[] args) {

    System.out.println("Просто капча c картинкой с цифрой");
    NumberCaptcha numberCaptcha = new NumberCaptcha();
    numberCaptcha.check2FA();

    System.out.println("\nКапча для мошенника с параметризированным конструктором");
    NumberCaptcha noNumberCaptcha = new NumberCaptcha(true);
    noNumberCaptcha.check2FA();

    System.out.println("\nПросто капча с картинкой с выбором направления");
    DirectionCaptcha directionCaptcha = new DirectionCaptcha();
    directionCaptcha.check2FA();

    System.out.println("\nКапча для мошенника с параметризированным конструктором (бесконечная)");
    DirectionCaptcha infinityDirectionCaptcha = new DirectionCaptcha(true);
    infinityDirectionCaptcha.check2FA();
  }
}
