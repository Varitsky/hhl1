public class lesson2task1 {

  public static void main(String[] args) {

    var name = "Имя";
    var surname = "Фамилия";
    var patronymic = "Отчество";
    var age = 50;
    var profession = "водитель";
    var experience = 10;

    getResume(name, surname, patronymic);
    getResume(name, surname, patronymic, age, profession);
    getResume(name, surname, patronymic, age, profession, experience);

    Resume resume = new Resume(name, surname, patronymic);
    MiddleResume middleResume = new MiddleResume(name, surname, patronymic, age, profession);
    BigResume bigResume = new BigResume(name, surname, patronymic, age, profession, experience);

    getResume(resume);
    getResume(middleResume);
    getResume(bigResume);
  }

  private static void getResume(String name, String surname, String patronymic) {

    System.out.println("Resume:");
    System.out.println("Name: " + name);
    System.out.println("Surname: " + surname);
    System.out.println("Patronymic: " + patronymic + "\n");
  }

  private static void getResume(String name, String surname, String patronymic, int age, String profession) {

    System.out.println("Resume:");
    System.out.println("Name: " + name);
    System.out.println("Surname: " + surname);
    System.out.println("Patronymic: " + patronymic);
    System.out.println("Age: " + age);
    System.out.println("Profession: " + profession + "\n");
  }

  private static void getResume(String name, String surname, String patronymic, int age, String profession, int experience) {

    System.out.println("Resume:");
    System.out.println("Name: " + name);
    System.out.println("Surname: " + surname);
    System.out.println("Patronymic: " + patronymic);
    System.out.println("Age: " + age);
    System.out.println("Profession: " + profession);
    System.out.println("Experience: " + experience + "\n");
  }

  private static void getResume(Resume resume) {

    System.out.println("Resume:");
    System.out.println("Name: " + resume.name);
    System.out.println("Surname: " + resume.surname);
    System.out.println("Patronymic: " + resume.patronymic + "\n");
  }

  private static void getResume(MiddleResume resume) {

    System.out.println("Resume:");
    System.out.println("Name: " + resume.name);
    System.out.println("Surname: " + resume.surname);
    System.out.println("Patronymic: " + resume.patronymic);
    System.out.println("Age: " + resume.age);
    System.out.println("Profession: " + resume.profession + "\n");
  }

  private static void getResume(BigResume resume) {

    System.out.println("Resume:");
    System.out.println("Name: " + resume.name);
    System.out.println("Surname: " + resume.surname);
    System.out.println("Patronymic: " + resume.patronymic);
    System.out.println("Age: " + resume.age);
    System.out.println("Profession: " + resume.profession);
    System.out.println("Experience: " + resume.experience + "\n");
  }

  public record Resume(String name, String surname, String patronymic) {}
  public record MiddleResume(String name, String surname, String patronymic, int age, String profession) {}
  public record BigResume(String name, String surname, String patronymic, int age, String profession, int experience) {}
}
