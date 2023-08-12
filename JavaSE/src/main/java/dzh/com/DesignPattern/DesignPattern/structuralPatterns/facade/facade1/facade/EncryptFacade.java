package dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.facade;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem.CipherMachine;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem.FileReader;
import dzh.com.DesignPattern.DesignPattern.structuralPatterns.facade.facade1.subSystem.FileWriter;

/**
 * 加密外观类
 */
public class EncryptFacade extends AbstractEncryptFacade {
    //维持对其他对象的引用
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    @Override
    public void fileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr, fileNameDes);
    }
}
