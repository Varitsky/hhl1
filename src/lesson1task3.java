import java.util.Scanner;

public class lesson1task3 {

  private static final Scanner scanner = new Scanner(System.in);


  public static void main(String[] args) {

    System.out.println("Максимум 6 человек, 450 кг, Заходят по очереди в лифт немцы, поляки и русские, весом... (вводим вес каждого по порядку)");
    var deadWeight = 0;
    var tolpaSize = 0;
    var cont = 1;

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
}
