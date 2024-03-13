package lesson3;

import java.util.Random;
import java.util.Scanner;
public class DirectionCaptcha extends Captcha implements Checkable{

  private static final Scanner SCANNER = new Scanner(System.in);
  private String correctButtonOfDirection;
  public String actualAnswerClientChooseOneOfThreeButtons;
  public String pictureWithDirection;


  DirectionCaptcha() {

    limit = 5;
    this.isFraud = false;
  }

  DirectionCaptcha(boolean isFraud) {

    if (isFraud) {
      limit = 5;
      this.isFraud = true;
      System.out.println("это мошенник/бот, гонять его по кругу бесконечно даже если капча верная");
    } else new DirectionCaptcha();
  }

  public String getPicture() {
    return pictureWithDirection;
  }

  @Override
  public void check2FA() {

    System.out.println("L = LEFT, C = CENTER, R = RIGHT\n");
    resetCount();
    while (isLimit(count, limit)) {

      generateCaptcha();
      captchaAnswerFromClient();

      if (this.actualAnswerClientChooseOneOfThreeButtons.equals(this.correctButtonOfDirection) && !isFraud) {
        System.out.println("Корректно, хорошо, это оно, капча пройдена");
        return;
      } else {
        System.out.println(wrongAnswer());
        if(!isFraud)super.increaseCount();
        System.out.println("попытка/лимит - " + count + "/" + limit);
      }
    }
    limitExceeded();
  }

  @Override
  protected void generateCaptcha() {

    pictureWithDirection = "generateNewPictureWithDirection";
    this.correctButtonOfDirection = String.valueOf(Direction.randomDirection());
    System.out.println("На экране картинка \""+ pictureWithDirection + "\", где стрелочка указывает на - \"" + this.correctButtonOfDirection + "\"");
  }

  private void captchaAnswerFromClient() {

    System.out.println("Под картинкой кнопки влево вправо или вперёд, кнопочки L R C, L R или C?");
    this.actualAnswerClientChooseOneOfThreeButtons = SCANNER.nextLine();
  }

  @Override
  public String wrongAnswer() {
    return "Неверное направление";
  }

  enum Direction {
    // "LEFT" "RIGHT" "CENTER"
    L,
    C,
    R;

    private static final Random RANDOM = new Random();

    private static Direction randomDirection() {

      Direction[] directions = values();
      return directions[RANDOM.nextInt(directions.length)];
    }
  }
}
