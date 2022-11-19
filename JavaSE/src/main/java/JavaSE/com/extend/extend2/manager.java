package JavaSE.com.extend.extend2;

public class manager extends employee {
    private  int bonus;

    public manager(String name, String id, int salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("项目经理"+getName()+"工资"+getSalary());
    }



    public static void main(String[] args) {
        manager manager=new manager("张三","001",20000,20000);
        manager.work();
    }
}
