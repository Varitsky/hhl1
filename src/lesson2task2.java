import java.util.Arrays;
import java.util.Random;

public class lesson2task2 {

  private static int sum = 0;
  private static int inc = 0;
  private static final Random random = new Random();


  public static void main(String[] args) {

    var arraySize = random.nextInt(5, 10);
    var array = new int[arraySize];

    recursionFillArray(0, array);
    recursion(0, array);
    sum = 0;
    inc = 0;
    shorterRecursion(array);
  }

  public static void recursionFillArray(int start, int[] array) {

    if (start < array.length - 1) {
      array[start] = random.nextInt(10);
      recursionFillArray(start + 1, array);
    } else System.out.println("Array: " + Arrays.toString(array));
  }

  public static void recursion(int start, int[] array) {

    if (start < array.length - 1) {
      sum = sum + array[start];
      recursion(start + 1, array);
    } else System.out.println("sum: " + sum);
  }


  public static void shorterRecursion(int[] array) {

    if (inc < array.length - 1) {
      sum = sum + array[inc];
      inc = inc + 1;
      shorterRecursion(array);
    } else System.out.println("shorterRecursionSum: " + sum);
  }
}
