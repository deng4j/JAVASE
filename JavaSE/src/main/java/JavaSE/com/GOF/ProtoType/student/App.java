package JavaSE.com.GOF.ProtoType.student;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Tools tools=new Tools("锤子");
        Skill skill=new Skill("打飞机",tools);
        Student student=new Student("张三",skill);

        Student cloneStu = student.clone();

        System.out.println("测试Student对象的skill对象："+(student.getSkill()==cloneStu.getSkill()));
        System.out.println("测试skill对象的tools对象："+(student.getSkill().getTool()==
        cloneStu.getSkill().getTool()));
        System.out.println("测试Student对象的name属性:"+(student.getName()==cloneStu.getName()));

    }
}
