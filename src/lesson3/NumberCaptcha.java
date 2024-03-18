package lesson3;

import java.util.Random;
import java.util.Scanner;

public class NumberCaptcha extends Captcha implements Checkable, Vocable {

  //случайное - текст/чтобы проще число/чтобы проще цифра/чтобы проще 0 1 или 2
  //классы выглядят почти одинаково, но теоретически это разные методы по выбору кнопок или полю ввода
  private static final Scanner SCANNER = new Scanner(System.in);
  private int correctZeroToTwoNumberAnswer;
  public int actualAnswerClientInputIntoFieldCaptcha;
  public String pictureOfNumber;


  NumberCaptcha() {
    limit = 5;
    this.isFraud = false;
  }

  NumberCaptcha(boolean isFraud) {

    if (isFraud) {
      this.isFraud = true;
      this.count = limit;
      System.out.println("это мошенник/бот, сразу лимит исчерпан");
    } else new NumberCaptcha();
  }

  public String getPicture() {
    return this.pictureOfNumber;
  }

  public int getCorrectZeroToTwoNumberAnswer() {
    return this.correctZeroToTwoNumberAnswer;
  }

  public int getLimit() {
    return limit;
  }

  @Override
  public void check2FA() {

    resetCount();
    while (isLimit(count, limit) && !isFraud) {

      captchaAnswerFromClient();

      if (this.actualAnswerClientInputIntoFieldCaptcha == this.correctZeroToTwoNumberAnswer) {
        System.out.println("Корректно, хорошо, это оно, капча пройдена");
        return;
      } else {
        System.out.println(wrongAnswer());
        super.increaseCount();
        System.out.println("попытка/лимит - " + count + "/" + limit);
        regenerateCaptcha();
      }
    }
    limitExceeded();
  }

  @Override
  protected NumberCaptcha generateCaptcha() {

    pictureOfNumber = "newPictureOfNumberForCaptcha";
    this.correctZeroToTwoNumberAnswer = new Random().nextInt(0,3);
    System.out.println("На экране картинка  \"" + pictureOfNumber + "\"с цифрой \"" + this.correctZeroToTwoNumberAnswer + "\"");
    return this;
  }

  protected NumberCaptcha regenerateCaptcha() {
    pictureOfNumber = "newPictureOfNumberForCaptcha";
    this.correctZeroToTwoNumberAnswer = new Random().nextInt(0,3);
    System.out.println("Новая капча: На экране картинка  \"" + pictureOfNumber + "\"с цифрой \"" + this.correctZeroToTwoNumberAnswer + "\"");
    return this;
  }

  private void captchaAnswerFromClient() {

    System.out.println("Под картинкой поле ввода текста, введите цифру с картинки:");
    this.actualAnswerClientInputIntoFieldCaptcha = Integer.parseInt(SCANNER.nextLine());
  }

  @Override
  public String wrongAnswer() {
    return "Неверная цифра";
  }

  @Override
  public NumberCaptcha readAloud() {
    System.out.println("Сгенерирован и воспроизведен аудиофайл, слышно как произносят " + this.correctZeroToTwoNumberAnswer + "\n");
    return this;
  }
}
