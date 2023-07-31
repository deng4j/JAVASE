package dzh.com.JavaSE.com.thinkingInJava4;


import java.util.ArrayList;
import java.util.List;

public class TestCite {

    private String name;
    private List<Integer> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TestCite{" + "name='" + name + '\'' + ", list=" + list + '}';
    }

    public static void main(String[] args) {
        cite2();
    }

    private static void cite2() {
        TestCite c1 = new TestCite();
        c1.setName("aaaa");
        TestCite c2 = new TestCite();
        c2.setName("bbbb");

        List<TestCite> citeList=new ArrayList<>();
        citeList.add(c1);
        citeList.add(c2);

        List<TestCite> cites=new ArrayList<>();
        cites.add(c1);
        cites.add(c2);

        c1.setName("1111");
        c2.setName("2222");
        System.out.println(citeList);
        System.out.println(cites);
    }

    private static void cite() {
        //引用
        TestCite student = new TestCite();

        List<Integer> list=new ArrayList<>();
        student.setList(list);
        list.add(1);

        list=new ArrayList<>();
        System.out.println(student);
    }
}
