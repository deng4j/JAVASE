package bjsxt.com.io.IOStream;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 递归查找子孙
 */
public class copyFolder {
    public static void main(String[] args) {
        //源目录
        String source="D:/idea/bjsxt/src/com/io/file/parent";
        File sourceFile=new File(source);
        //目标目录
        String end="D:/idea/bjsxt/src/com/io/file/copyfile";
        File endFile=new File(end);
        copyDir(sourceFile,endFile);

    }

    public static void copyDir(File sourceFile, File endFile){
        //如果是一个文件夹,拷贝一个一样的
        if (sourceFile.isDirectory()){
            endFile=new File(endFile,sourceFile.getName());
        }
        copyDirDeteain(sourceFile,endFile);
    }
    /**
     * 拷贝文件夹细节
     * @param sourceFile
     * @param endFile
     */
    private static void copyDirDeteain(File sourceFile, File endFile) {
        if (sourceFile.isFile()){
            try {
                copyFile.copyFile(sourceFile,endFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (sourceFile.isDirectory()){
            //确保目标文件夹存在
            endFile.mkdirs();
            //获取下一级目录|文件
            for (File f :sourceFile.listFiles()) {
                copyDirDeteain(f,new File(endFile,f.getName()));
            }
        }
    }

}
