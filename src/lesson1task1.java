import java.util.Scanner;

public class lesson1task1 {

  private static final Scanner SCANNER = new Scanner(System.in);


  public static void main(String[] args) {

    System.out.println("Введите трёхзначное число");

    var inputNumber = SCANNER.nextLine();
    var num = Integer.parseInt(inputNumber);
    System.out.println("Трёхзначное число: " + num);

    if (num > 500) {
      num = num%10*100 + num%100-num%10 + (num-(num%100))/100;
    } else {
      num = num-(num%100) + num%10*10 + (num%100-num%10)/10 ;
    }
    System.out.println("Перевернутое числое:" + num);
  }
}
