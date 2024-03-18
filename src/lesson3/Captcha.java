package lesson3;

abstract class Captcha {

  int count;
  boolean isFraud;
  static int limit;


  protected void increaseCount() {
    this.count = this.count + 1;
  }

  protected void resetCount() {
    this.count = 0;
  }

  protected abstract Captcha generateCaptcha();
  protected abstract Captcha regenerateCaptcha();

  protected boolean isLimit(int count, int limit) {
    return (count < limit);
  }

  protected static void limitExceeded() {
    System.out.println("Limit " + limit + " Exceeded");
  }

  protected String getPicture() {
    return null;
  }
}
