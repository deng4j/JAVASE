package dzh.com.DesignPattern.DesignPattern.structuralPatterns.composite.killvirus;

/**
 * 处理树形关系
 * 使用组合模式模拟杀毒
 */
public class App {
    public static void main(String[] args) {
        AbstractFile f2,f3,f6,f7;
        Folder f1=new Folder("我的收藏");
        f2=new ImageFile("av.jpg");
        f3=new TxtFile("我的种子");

        f1.add(f2);
        f1.add(f3);
        f1.killVirus();
        System.out.println("----------------");

        Folder f4 = new Folder("我的文件夹");
        f6=new ImageFile("天龙八部");
        f7=new TxtFile("斗破苍穹");

        f4.add(f6);
        f4.add(f7);
        f4.add(f1);
        f4.killVirus();


    }
}
