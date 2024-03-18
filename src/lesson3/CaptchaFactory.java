package lesson3;

import java.util.function.Supplier;

public class CaptchaFactory<T extends Captcha> {

  private final Supplier<T> supplier;

  public CaptchaFactory(Supplier<T> supplier) {
    this.supplier = supplier;
  }

  public T createCaptcha() {
    return supplier.get();
  }

}


