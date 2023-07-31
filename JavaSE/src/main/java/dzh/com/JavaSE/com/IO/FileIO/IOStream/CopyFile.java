package dzh.com.JavaSE.com.IO.FileIO.IOStream;

import java.io.*;

/**
 * BufferedInputStream,BufferedOutputStream创建了一个8192的byte[]
 */
public class CopyFile {
    public static void main(String[] args) {
        String classPath = CopyFile.class.getClassLoader().getResource("").getPath();

        File source=new File(classPath+"io/folder/b/ghh.jpg");
        File dest=new File(classPath+"io/folder/b/copybak.jpg");
        CopyFile(source, dest);
    }

    private static void CopyFile(File source, File dest) {
        InputStream is=null;
        OutputStream os=null;
        byte[] bytes=null;
        int len=0;
        try {
            is=new BufferedInputStream(new FileInputStream(source));
            os=new BufferedOutputStream(new FileOutputStream(dest));
            bytes=new byte[8192];
            while (-1!=(len=is.read(bytes))){
                System.out.println(len);
                os.write(bytes,0,len);
            }
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null!=os){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
