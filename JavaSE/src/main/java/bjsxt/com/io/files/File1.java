package bjsxt.com.io.files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 1.pathseparator 路径分隔符;
 * 2.separator 名称分隔符\(windows)  /(linux等)
 */
public class File1 {
    public static void main(String[] args) {
        //绝对路径
        String path="D:\\idea\\bjsxt\\src\\com\\io\\file\\1.jpg";
        path="D:"+File.separator+"idea"+File.separator+"bjsxt"
                +File.separator+"io"+File.separator+"file"
                +File.separator+"1.jpg";
        //推荐
        path="D:/idea/bjsxt/src/com/io/file/1.jpg";
        //----------------------------
        //绝对路径以盘符开头
        path="D:/idea/bjsxt/src/com/io/file/1.txt";
        path="D:/idea/bjsxt/src/com/io/file";
        String name="1.txt";
        File file1=new File(path);
        File file=new File(path,name);
        file=new File(new File(path),name);
        //创建文件,确保文件父文件夹存在
        if (file.exists()){
            System.out.println("文件已创建");
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getName());
        System.out.println(file.getPath());
        //返回上一级
        System.out.println("返回上一级"+file.getParent());
        //文件读写
        System.out.println("文件可读"+file.canRead());
        System.out.println("文件可写"+file.canWrite());
        System.out.println("是文件："+file.isFile());
        System.out.println("是文件："+file.isDirectory());
        System.out.println("是绝对路径吗："+file.isAbsolute());
        System.out.println("文件长度："+file.length());

        //删除文件
        File file2=new File("D:/idea/bjsxt/src/com/io/file/2.txt");
        if (file2.exists()){
            file2.delete();
            System.out.println("删除"+file2.getName()+"成功");
        }else {
            System.out.println("文件不存在");
        }
        //创建临时文件static createTempFile(前缀3个字节长，后缀默认.temp,目录);
        File temp=null;
        try {
           temp=  File.createTempFile("temp",".temp",new File("D:/idea/bjsxt/src/com/io/file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //退出即删除
       temp.deleteOnExit();

        /**
         * 操作目录
         * mkdir（）创建目录，确保父目录存在，否则失败
         * mkdirs()如果目录不存在，系统一同创建
         */
        String folder="D:/idea/bjsxt/src/com/io/file/parent/child";
        File file3=new File(folder);
        file3.mkdirs();
        //list操作
        if (file1.isDirectory()){
            //返回路径和文件名
            File[] subName=file1.listFiles();
            for (int i = 0; i < subName.length; i++) {
                System.out.println(subName[i]);
            }
            //子文件，java对象
              //命令设计模式,过滤文件
            subName=file1.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir,name).isFile()&&name.endsWith(".java");
                }
            });
            for (int i = 0; i < subName.length; i++) {
                System.out.println(subName[i]);
            }
        }

    }
}
