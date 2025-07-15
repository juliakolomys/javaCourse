import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {
    private final List<Integer> marks;
    private boolean isBlocked = false;
    private String group;

    public Student(String name, int age, int id, List<Integer> marks) {
        super(name, age, id);
        this.marks = new ArrayList<>(marks);
        this.group = null;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        if (!isBlocked) {
            super.setName(name);
        } else {
            System.out.println("Impossible to change name since student is graduated");
        }
    }


    public List<Integer> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    public void addMark(int mark) {
        if (!isBlocked) {
            marks.add(mark);
        } else {
            System.out.println("Impossible to change mark since student is graduated");
        }
    }

    public void removeMark(int index) {
        if (!isBlocked) {
            if (index > -1 & index < marks.size()) {
                marks.remove(index);
            } else {
                System.out.println("Incorrect index");
            }
        } else {
            System.out.println("Impossible to remove mark since student is graduated");
        }
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void unblock() {
        this.isBlocked = false;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        if (marks == null || marks.isEmpty()) return 0.0;
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.size();
    }


    @Override
    public String toString() {
        String result = getName() + " " + marks;
        if (group != null) {
            result += " (" + group + ")";
        }
        return result;
    }


}

