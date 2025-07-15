import java.util.Collections;

import java.util.ArrayList;
import java.util.List;
public class Dispatcher {
    private List<Group> groups;
    private List<Teacher> biologyTeachers;
    private List<Teacher> mathTeachers;

    public Dispatcher() {
        setupData();
    }

    private void setupData() {
        Group group1 = new Group("Group A");
        Group group2 = new Group("Group B");

        Student s1 = new Student("Helen", 17, 1, new ArrayList<>(List.of(5, 4)));
        Student s2 = new Student("Max", 18, 2, new ArrayList<>(List.of(3, 4)));
        Student s3 = new Student("Anna", 18, 3, new ArrayList<>(List.of(5, 5)));
        Student s4 = new Student("Liza", 16, 4, new ArrayList<>(List.of(5, 3)));

        group1.addStudent(s1);
        group1.addStudent(s2);
        group2.addStudent(s3);
        group2.addStudent(s4);

        groups = List.of(group1, group2);

        Teacher t1 = new Teacher("Nesterenko", 35, 01, "Biology");
        Teacher t2 = new Teacher("Prokopov", 45, 02, "Biology");
        Teacher t3 = new Teacher("Dovgal", 40, 03, "Math");
        Teacher t4 = new Teacher("Nikitiuk", 50, 04, "Math");

        biologyTeachers = List.of(t1, t2);
        mathTeachers = List.of(t3, t4);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Teacher> getTeachersBySubject(String subject) {
        return switch (subject.toLowerCase()) {
            case "biology" -> biologyTeachers;
            case "math" -> mathTeachers;
            default -> Collections.emptyList();
        };
    }
}

