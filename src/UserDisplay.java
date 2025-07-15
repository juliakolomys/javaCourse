import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDisplay {
    private Dispatcher dispatcher = new Dispatcher();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Показати список груп");
            System.out.println("2. Показати список вчителів");
            System.out.println("3. Рейтинг студентів");
            System.out.println("4. Вийти");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showGroups();
                case 2 -> showTeachersMenu();
                case 3 -> studentRating();
                case 4 -> System.out.println("Вихід з програми");
                default -> System.out.println("Неправильний вибір");
            }
        } while (choice != 4);
    }

    private void showGroups() {
        List<Group> groups = dispatcher.getGroups();
        System.out.println("\nСписок груп:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i));
        }
        System.out.print("Виберіть групу за номером: ");
        int groupChoice = scanner.nextInt();

        if (groupChoice > 0 & groupChoice < groups.size()) {
            Group selectedGroup = groups.get(groupChoice - 1);
            List<Student> students = selectedGroup.getStudents();
            if (students.isEmpty()) {
                System.out.println("Група ще порожня");
                return;
            }
            System.out.println("\nСтуденти в " + selectedGroup + ":");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
            System.out.print("Виберіть студента за номером для перегляду деталей: ");
            int studentChoice = scanner.nextInt();
            if (studentChoice > 0 & studentChoice < students.size()) {
                System.out.println(students.get(studentChoice - 1));
            } else {
                System.out.println("Неправильний номер студента");
            }
        } else {
            System.out.println("Неправильний номер групи");
        }
    }

    private void showTeachersMenu() {
        System.out.println("\nПредмети:");
        System.out.println("1. Біологія");
        System.out.println("2. Математика");
        System.out.print("Оберіть предмет за номером: ");
        int subjectChoice = scanner.nextInt();

        String subject;
        switch (subjectChoice) {
            case 1 -> subject = "biology";
            case 2 -> subject = "math";
            default -> {
                System.out.println("Неправильний вибір предмета");
                return;
            }
        }

        List<Teacher> teachers = dispatcher.getTeachersBySubject(subject);
        System.out.println("\nВикладачі з предмету " + subject + ":");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getName());
        }

        System.out.print("Оберіть викладача за номером для перегляду деталей: ");
        int teacherChoice = scanner.nextInt();

        if (teacherChoice > 0 & teacherChoice < teachers.size()) {
            System.out.println(teachers.get(teacherChoice - 1));
        } else {
            System.out.println("Неправильний номер викладача");
        }
    }

    private void studentRating() {
        List<Student> allStudents = new ArrayList<>();
        for (Group g : dispatcher.getGroups()) {
            allStudents.addAll(g.getStudents());
        }

        if (allStudents.isEmpty()) {
            System.out.println("Немає студентів для порівняння");
            return;
        }

        allStudents.sort((a, b) -> Double.compare(b.getAverageMark(), a.getAverageMark()));

        System.out.println("\nРейтинг студентів:");
        for (Student st : allStudents) {
            System.out.printf("%s — середній бал: %.2f%n", st.getName(), st.getAverageMark());
        }
    }


}

