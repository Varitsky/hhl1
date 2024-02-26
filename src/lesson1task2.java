public class lesson1task2 {

  public static void main(String[] args) {

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
}
