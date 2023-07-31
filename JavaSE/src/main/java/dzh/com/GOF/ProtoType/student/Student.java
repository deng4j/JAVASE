package dzh.com.GOF.ProtoType.student;

public class Student implements Cloneable {
    private String name;
    private Skill skill;

    public Student(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student student= (Student) super.clone();

        student.skill= (Skill) this.skill.clone();

        return student;
    }
}
