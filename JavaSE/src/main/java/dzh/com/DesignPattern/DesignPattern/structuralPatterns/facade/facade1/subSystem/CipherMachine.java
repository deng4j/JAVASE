package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem;

/**
 * 数据加密类
 */
public class CipherMachine {
    public String encrypt(String plainText) {
        System.out.println("数据加密，将明文加密为密文");
        return "XHJKTUYFFAIDSDJLK";
    }
}
