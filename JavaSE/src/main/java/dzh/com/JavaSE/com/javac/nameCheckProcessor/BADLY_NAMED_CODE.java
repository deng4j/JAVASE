package dzh.com.JavaSE.com.javac.nameCheckProcessor;

/**
 * 测试JDK21编译：
 * javac dzh/com/JavaSE/com/javac/nameCheckProcessor/NameChecker.java dzh/com/JavaSE/com/javac/nameCheckProcessor/NameCheckProcessor.java
 * <p>
 * 以通过Javac命令的“-processor”参数来执行编译时需要附带的注解处理器，如果有多个注解处理器的话，用逗号分隔。
 * javac -processor dzh.com.JavaSE.com.javac.nameCheckProcessor.NameCheckProcessor  dzh/com/JavaSE/com/javac/nameCheckProcessor/BADLY_NAMED_CODE.java
 */
class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {
        return;
    }

    public static void main(String[] args) {
        System.out.println("BADLY_NAMED_CODE");
    }
}