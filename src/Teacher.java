public class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, int id, String subject) {
        super(name, age, id);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public void teach() {
        System.out.println(getName() + " is teaching " + subject);
    }

    @Override
    public String toString() {
        return "Teacher" + getName() + "'s age is " + getAge() + ", id is " + getId() +
                ", subject is " + subject;
    }
}
