package JavaSE.com.GOF.ProtoType.student;

public class Skill implements Cloneable{
    private String name;
    private Tools tool;

    public Skill(String name, Tools tool) {
        this.name = name;
        this.tool = tool;
    }


    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tools getTool() {
        return tool;
    }

    public void setTool(Tools tool) {
        this.tool = tool;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
