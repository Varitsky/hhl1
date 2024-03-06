package lesson3;

public class PictureOfCaptcha <T extends Captcha> {

  public T captcha;
  public void getPictureOfCaptcha() {
    System.out.println(captcha == null ? "нет пока ничего" : captcha.getPicture());
  }
  public void setCaptcha(T someCaptcha) {
    this.captcha = someCaptcha;
  }
}
