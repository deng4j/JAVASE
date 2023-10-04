package dzh.com.JavaSE.com.characteristic.stream.demo.sortArea;

public class Area {

    private String name;

    public Area(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" + "name='" + name + '\'' + '}'+"\n";
    }
}
