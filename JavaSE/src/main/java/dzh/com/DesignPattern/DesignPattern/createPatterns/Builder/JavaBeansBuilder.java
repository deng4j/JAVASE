package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder;

public class JavaBeansBuilder {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public JavaBeansBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JavaBeansBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "JavaBeansBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        JavaBeansBuilder javaBeansBuilder = new JavaBeansBuilder();
        javaBeansBuilder.setId(1)
                .setName("zs");
        System.out.println(javaBeansBuilder);
    }
}
