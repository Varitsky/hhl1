package lesson3;

public class lesson8 {
  public static void main(String[] args) {

    CaptchaFactory<NumberCaptcha> numberCaptchaCaptchaFactory = new CaptchaFactory<NumberCaptcha>(NumberCaptcha::new);
    NumberCaptcha numberCaptcha = numberCaptchaCaptchaFactory.createCaptcha();

    numberCaptcha.generateCaptcha()
        .readAloud()
        .check2FA();

    CaptchaFactory<DirectionCaptcha> directionCaptchaCaptchaFactory = new CaptchaFactory<DirectionCaptcha>(DirectionCaptcha::new);
    DirectionCaptcha directionCaptcha = directionCaptchaCaptchaFactory.createCaptcha();

    directionCaptcha.generateCaptcha()
        .regenerateCaptcha()
        .regenerateCaptcha()
        .check2FA();
  }
}
