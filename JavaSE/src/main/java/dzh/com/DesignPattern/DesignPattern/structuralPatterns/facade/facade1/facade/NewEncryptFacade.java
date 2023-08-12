package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.facade;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem.CipherMachine;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem.FileReader;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem.FileWriter;

/**
 * 新加密外观类
 */
public class NewEncryptFacade extends AbstractEncryptFacade {
    //维持对其他对象的引用
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public NewEncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    @Override
    public void fileEncrypt(String fileNameSrc, String fileNameDes) {
        System.out.println("-----新外观系统-----");
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr, fileNameDes);
    }
}
