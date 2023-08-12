package dzh.com.DesignPattern.DesignPattern.structuralPatterns.composite.fileSearch;

public class File implements Leaf {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("文件："+name);
    }
}
