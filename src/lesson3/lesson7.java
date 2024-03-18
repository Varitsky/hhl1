package lesson3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class lesson7 {
  private static final Random RANDOM = new Random();
  public static void main(String[] args) {

    Set<NumberCaptcha> captchaSet = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      NumberCaptcha captcha = new NumberCaptcha();
      captcha.generateCaptcha();
      captchaSet.add(captcha);
    }

    numberedCaptchaAnswersCount(captchaSet);

    // Брутфорсим числовую капчу числом 2.
    int attempt = IntStream.range(0, captchaSet.size())
        .filter(index -> captchaSet.stream()
            .map(NumberCaptcha::getCorrectZeroToTwoNumberAnswer)
            .toList()
            .get(index) == 2)
        .findFirst()
        .orElse(-1);
    if (attempt != -1) {
      System.out.println("Угадали с попытки номер " + (attempt + 1));
    } else {
      System.out.println("Не взломали");
    }


    //Насколько сложно сломать капчу (просто было интересно увидеть +-33%, и там и правда всегда +-33%
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      numbers.add(RANDOM.nextInt(3));
    }
    long matches = numbers.stream()
        .filter(number -> number == RANDOM.nextInt(3))
        .count();
    double percentage = (double) matches / numbers.size() * 100;
    System.out.println("Угадали: " + matches + ", Процент угадывания: " + percentage + "%");


    // Ломаем много капчей в стриме методом со стримом
    List<NumberCaptcha> captchaList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      NumberCaptcha numberCaptcha = new NumberCaptcha();
      numberCaptcha.generateCaptcha();
      captchaList.add(numberCaptcha);
    }

    long successfulBruteForce = captchaList.stream()
        .filter(lesson7::bruteForceNumberCaptcha)
        .count();
    System.out.println("Успешных взломов: " + successfulBruteForce);
  }


  public static boolean bruteForceNumberCaptcha(NumberCaptcha captcha) {

    int attempt = IntStream.range(1, captcha.getLimit())
        .filter(attemptNumber -> RANDOM.nextInt(3) == captcha.getCorrectZeroToTwoNumberAnswer())
        .findFirst()
        .orElse(-1);

    if (attempt != -1) {
      System.out.println("Взломали с " + attempt + " попытки.");
      return true;
    } else {
      System.out.println("Не взломали.");
      return false;
    }
  }

  public static void numberedCaptchaAnswersCount(Set<NumberCaptcha> captchaSet) {

    Map<Integer, Long> numberedAnswers = captchaSet.stream()
        .collect(Collectors.groupingBy(NumberCaptcha::getCorrectZeroToTwoNumberAnswer, Collectors.counting()));
    System.out.println("Подсчет вариантов капчи: " + numberedAnswers);
  }
}

