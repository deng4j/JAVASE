package dzh.com.DesignPattern.DesignPattern.structuralPatterns.composite.fileSearch;

public class Client {
    public static void main(String[] args) {
        Component f1 = new File("波多FHX312");
        Component f2 = new File("苍井空CHFK3");
        Component f3 = new File("泷泽萝拉GJ312");

        Folder fd1 =new Folder("绩优股");
        fd1.add(f1);
        fd1.add(f2);
        fd1.add(f3);

        fd1.operation();
    }
}
