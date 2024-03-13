package lesson5;

public class task2 {
  public static void main(String[] args) {

    Divisible taskTwo = (number) -> number % 13 == 0;

    System.out.println(taskTwo.test(13));
    System.out.println(taskTwo.test(15));
    System.out.println(taskTwo.test(25));
  }
}