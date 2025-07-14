import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final List<Student> students = new ArrayList<>();
    private boolean isGraduated = false;
    private static boolean groupGraduated = false;
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) {
        if (!groupGraduated) {
            if (!student.isBlocked()) {
                if (student.getGroup() == null) {
                    students.add(student);
                    student.setGroup(groupName);
                    System.out.println(student.getName() + " added to " + groupName);
                } else {
                    System.out.println("Student " + student.getName() + " is already in " + student.getGroup());
                }
            } else {
                System.out.println("Impossible to add graduated student" + student.getName() + " to new group");
            }
        } else {
            System.out.println("Impossible to add student after graduation");
        }
    }

    public void removeStudent(Student student) {
        if (!isGraduated) {
            if (students.remove(student)) {
                student.setGroup(null);
                System.out.println(student.getName() + " is removed from " + groupName);
            } else {
                System.out.println("Student " + student.getName() + " isnt in " + groupName);
            }
        } else {
            System.out.println("Impossible to remove student from graduated group");
        }
    }

    public void graduate() {
        isGraduated = true;
        groupGraduated = true;
        System.out.println("Group " + groupName + " is graduated");
        for (Student s : students) {
            s.block();
        }
    }

    public void reenter(Student student) {
        if (student.getGroup() != null & student.isBlocked()) {
            System.out.println("Student " + student.getName() + " used to be in " + student.getGroup() +
                    " and reenter " + groupName);
            student.unblock();
            student.setGroup(groupName);
            students.add(student);
        } else {
            System.out.println("Impossible to reenter for this student");
        }
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(new ArrayList<>(students));
    }

    @Override
    public String toString() {
        return groupName;
    }
}



