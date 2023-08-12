package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem;

/**
 * 文件保存类
 */
public class FileWriter {

    public void write(String encryptStr, String fileNameDes) {
        System.out.println(encryptStr+" 写入到 "+fileNameDes);
    }
}
