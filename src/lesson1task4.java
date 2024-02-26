import java.util.Arrays;
import java.util.Random;

public class lesson1task4 {

  public static void main(String[] args) {

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
