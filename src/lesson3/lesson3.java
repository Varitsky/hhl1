package lesson3;

import java.util.Random;

import static lesson3.DirectionCaptcha.Direction;

public class lesson3 {
  private static final Random RANDOM = new Random();
  public static void main(String[] args) {

    RandomInput<String> randomString = () -> String.valueOf(RANDOM.nextInt(2));

    RandomInput<Direction> randomDirection = () -> {
      Direction[] values = Direction.values();
      return values[RANDOM.nextInt(values.length)];
    };

    System.out.println("Просто капча c картинкой с цифрой");
    NumberCaptcha numberCaptcha = new NumberCaptcha();
    System.out.println("[Новенькое с задания 5] Предлагаю выбрать: \"" + randomString.generate() + "\", вдруг повезёт.[Новенькое с задания 5] ");
    numberCaptcha.check2FA();

//    NumberCaptcha noNumberCaptcha = new NumberCaptcha(true);
//    noNumberCaptcha.check2FA();

    System.out.println("\nПросто капча с картинкой с выбором направления");
    DirectionCaptcha directionCaptcha = new DirectionCaptcha();
    Direction randomEnum = randomDirection.generate();
    System.out.println("[Новенькое с задания 5] Предлагаю выбрать: \"" + randomEnum + "\", вдруг повезёт.[Новенькое с задания 5] ");
    directionCaptcha.check2FA();

//    DirectionCaptcha infinityDirectionCaptcha = new DirectionCaptcha(true);
//    infinityDirectionCaptcha.check2FA();

    PictureOfCaptcha<NumberCaptcha> somethingForLessonOneOfThree = new PictureOfCaptcha<NumberCaptcha>();
    somethingForLessonOneOfThree.setCaptcha(numberCaptcha);
    somethingForLessonOneOfThree.getPictureOfCaptcha();

    PictureOfCaptcha<DirectionCaptcha> somethingForLessonTwoOfThree = new PictureOfCaptcha<DirectionCaptcha>();
    somethingForLessonTwoOfThree.setCaptcha(directionCaptcha);
    somethingForLessonTwoOfThree.getPictureOfCaptcha();

    PictureOfCaptcha<Captcha> somethingForLessonThreeOfThree = new PictureOfCaptcha<Captcha>();
    somethingForLessonThreeOfThree.getPictureOfCaptcha();
  }
}
