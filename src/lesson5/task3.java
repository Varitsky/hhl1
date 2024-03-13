package lesson5;

public class task3 {
  public static void main(String[] args) {

    Calculateable discriminant = (a, b, c) -> b * b - 4 * a * c;

    double result = discriminant.calculate(1, 2, 3);
    System.out.println("Дискриминант: " + result);

    double doubleTypeResult = discriminant.calculate(1.12, 3.18, 2.2);
    System.out.println("Дискриминант: " + doubleTypeResult);
  }
}