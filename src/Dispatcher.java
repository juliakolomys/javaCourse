import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Dispatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> marksA = new ArrayList<>(List.of(90, 85));
        List<Integer> marksB = new ArrayList<>(List.of(75));
        List<Integer> marksC = new ArrayList<>(List.of(85));
        List<Integer> marksD = new ArrayList<>(List.of(85));

        Student studentA = new Student("Alice", 17, 1, marksA);
        Student studentB = new Student("Artem", 16, 2, marksB);
        Student studentC = new Student("Nick", 18, 3, marksC);

        Teacher teacher = new Teacher("Nesterenko", 40, 100, "Math");
///////////////////
        Group group = new Group("KND");
        Student studentD = new Student("Helen", 16, 2, marksB);
        group.addStudent(studentD);

        studentD.setName("Mary");
        studentD.addMark(100);

        group.addStudent(new Student("Artem",16, 24, marksC));
        //   group = new Group("A");

        group.addStudent(studentB);
        group.addStudent(new Student("Andrew", 18, 003, marksB));

  //      System.out.println(group.getStudents());

        int choice;
        do {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Показати деталі StudentA");
            System.out.println("2. Показати деталі StudentB");
            System.out.println("3. Показати деталі вчителя");
            System.out.println("4. Показаи деталі PersonA");
            System.out.println("5. Порівняти середні оцінки StudentA та StudentC");
            System.out.println("6. Вчитель проводить заняття");
            System.out.println("7. Вийти");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println(studentA);
                case 2 -> System.out.println(studentB);
                case 3 -> System.out.println(teacher);
                case 4 -> {
                    Person personA = new Person("First person", 30, 001);
                    System.out.println(personA);
                }
                case 5 -> {
                    double avgA = average(studentA.getMarks());
                    double avgC = average(studentC.getMarks());

                    System.out.println("Середня оцінка StudentA: " + avgA);
                    System.out.println("Середня оцінка StudentC: " + avgC);

                    if (avgA > avgC) {
                        System.out.println("StudentA має вищу середню оцінку");
                    } else if (avgA < avgC) {
                        System.out.println("StudentC має вищу середню оцінку");
                    } else {
                        System.out.println("Середні оцінки однакові");
                    }
                }
                case 6 -> teacher.teach();
                case 7 -> System.out.println("Закінчити програму");
                default -> System.out.println("Неправильний вибір");
            }
        } while (choice != 7);
    }

    private static double average(List<Integer> marks) {
        if (marks.isEmpty()) return 0.0;
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }
}
