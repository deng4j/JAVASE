package dzh.com.DesignPattern.DesignPattern.structuralPatterns.composite.fileSearch;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Composite{
    private String name;
    private List<Component> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("-----文件夹："+name+"-----");
        for (Component component : list) {
            component.operation();
        }
    }

    @Override
    public void add(Component c) {
        list.add(c);
    }

    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public Component getChild(int index) {
        return list.get(index);
    }
}
