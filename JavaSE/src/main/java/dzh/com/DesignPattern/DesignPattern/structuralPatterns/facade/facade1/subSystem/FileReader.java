package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem;

/**
 * 文件读取类
 */
public class FileReader {
    public String read(String fileNameSrc) {
        System.out.println("读取文件"+fileNameSrc+"，获取明文");
        return "我是明文";
    }
}
