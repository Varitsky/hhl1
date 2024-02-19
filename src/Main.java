import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    /** Напишите программу, которая принимает с клавиатуры целое трехзначное положительное число и изменяет его следующим образом:
     для чисел, больших 500, - переставляет местами числа единиц и сотен (вместо 672 - 276);
     в остальных числах переставляются местами числа десятков и единиц (вместо 363 - 336).
     Программа должна вывести на экран новое значение переменной.
     **/
    System.out.println(autoTask1("672"));
    System.out.println(autoTask1("363"));
    System.out.println(autoTask1("500"));
    task1();

    /**
     * Напишите программу, которая выводит на экран все трехзначные числа, для которых соблюдаются два условия:
     * • само число заканчивается на 0;
     * • сумма нечетных делителей этого числа тоже заканчивается на 0.
     **/
//    task2();

    /**В инструкции по пользованию лифтом в торговом центре написано: «Не более 6 человек или не более 450 кг».
     * Перед входом в лифт установлен прибор, который подсчитывает входящих в лифт и определяет вес до входа в лифт.
     * Прибор автоматически прекращает доступ к лифту, если вход очередного человека может нарушить инструкцию.
     * Напишите программу, которая принимает с клавиатуры значения, каждое из которых - вес очередного человека, входящего в лифт.
     * Ввод данных продолжается до тех пор, пока соблюдается требование, указанное в инструкции.
     * Программа должна выводить на экран следующую итоговую информацию:
     *
     • количество людей, вошедших в лифт;
     • общий их вес;
     • причина, по которой прекращен вход людей в лифт.
     **/
    // допустим что 450 без <=, просто <

//    task3();

    /** Напишите программу, которая формирует два массива (не обязательно одинакового размера) целых чисел.
     * Программа возвращает массив значений, которые присутствуют в первом массиве, но не присутствуют во втором.
     **/
    task4();
  }

  public static String autoTask1(String number) {

    int num = Integer.parseInt(number);
    System.out.println("Трёхзначное число: " + num);
    char[] array = number.toCharArray();
    char temp = array[2];
    if (num > 500) {
      array[2] = array[0];
      array[0] = temp;
    } else {
      array[2] = array[1];
      array[1] = temp;
    }
    return "Перевернутое числое:" + String.valueOf(array);
  }

  public static void task1() {

    System.out.println("Введите трёхзначное число");

    var inputNumber = scanner.nextLine();
    int num = Integer.parseInt(inputNumber);
    char[] array = inputNumber.toCharArray();
    System.out.println("Трёхзначное число: " + num);

    char temp = array[2];
    if (num > 500) {
      array[2] = array[0];
      array[0] = temp;
    } else {
      array[2] = array[1];
      array[1] = temp;
    }

    System.out.println("Перевернутое числое:" + String.valueOf(array));
  }

  public static void task2() {

    for (int i = 0; i < 1000; i++) {
      if (i%10 == 0) {
        System.out.println(i + " - число заканчивается на 0");
      }
      int sum = 0;
      for (int j = 1; j < i; j=j+2) {

        if (i%j == 0) {
          sum = sum + j;
        }
      }
      if (sum%10 == 0 && sum > 1) {
        System.out.println(i + " - сумма нечетных делителей этого числа заканчивается на 0");
      }
    }
  }

  public static void task3() {

    System.out.println("Максимум 6 человек, 450 кг, Заходят по очереди в лифт немцы, поляки и русские, весом... (вводим вес каждого по порядку)");
    int deadWeight = 0;
    int tolpaSize = 0;
    int cont = 1;

    while(deadWeight < 450 && tolpaSize < 6 && cont == 1) {

      System.out.println("Вес следующего лифтопользователя:");
      int personWeight = Integer.parseInt(scanner.nextLine());

      if (deadWeight + personWeight < 450) {
        deadWeight = deadWeight + personWeight;
        tolpaSize = tolpaSize + 1;
        System.out.println("Сейчас в лифте людей - " + tolpaSize + " шт., обший вес - " + deadWeight);
      } else {
        System.out.println("Ограничение по весу. Если этот зайдет, то будет " + (deadWeight + personWeight) + "кг.");
        System.out.println("Может есть кто другой поменьше, может влезет? Введите \"1\" если да, или что-то другое если нет и на этом всё");
        cont = Integer.parseInt(scanner.nextLine());
      }
    }

    if (tolpaSize == 6) {
      System.out.println("Достигнут максимум 6 человек в лифте.");
    }
    System.out.println("Итого, в лифте людей - " + tolpaSize + " шт., обший вес - " + deadWeight);
  }

  public static void task4() {

    var rand = new Random();
    var firstArraySize = rand.nextInt(5, 10);
    var secondArraySize = rand.nextInt(5, 10);
    var firstArray = new int[firstArraySize];
    var secondArray = new int[secondArraySize];


    System.out.println("Генериуем Первый массив размером от 5 до 10 чисел, с случайнми числами от 1 до 10:");
    for (int i = 0; i < firstArraySize; i++) {
      firstArray[i] = rand.nextInt(10);
    }
    System.out.println("Первый массив:" + Arrays.toString(firstArray));

    System.out.println("Генериуем Второй массив размером от 5 до 10 чисел, с случайнми числами от 1 до 10:");
    for (int i = 0; i < secondArraySize; i++) {
      secondArray[i] = rand.nextInt(10);
    }
    System.out.println("Второй массив:" + Arrays.toString(secondArray));


    var variableLengthCrutchOfResultArray = firstArraySize;
    var modifiedCopyOfFirstArray = new int[firstArraySize];

    for (int i = 0; i < firstArraySize; i++) {
      for (int j = 0; j < secondArraySize; j++) {
        if (firstArray[i] == secondArray[j]) {
          modifiedCopyOfFirstArray[i] = 99;
          variableLengthCrutchOfResultArray--;
          break;
        } else {
          modifiedCopyOfFirstArray[i] = firstArray[i];
        }
      }
    }

    if (variableLengthCrutchOfResultArray == 0) {
      System.out.println("Все числа из первого массива были во втором");
    } else {
      var resultArray = new int[variableLengthCrutchOfResultArray];
      var indexOfResultArray = 0;
      for (int i = 0; i < firstArraySize; i++) {
        if (modifiedCopyOfFirstArray[i] != 99) {
          resultArray[indexOfResultArray] = modifiedCopyOfFirstArray[i];
          indexOfResultArray++;
        }
      }
      System.out.println("Значения, которые присутствуют в первом массиве, но не присутствуют во втором:" + Arrays.toString(resultArray));
    }
  }
}
