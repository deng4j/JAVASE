package JavaSE.com.stream.domain;

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
