package JavaSE.com.IO.file;

import JavaSE.com.IO.classloader.ClassLoaderTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * delete只能删除文件和空文件夹
 */
public class listFiles {
    public static void main(String[] args) {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        String absolutePath="io/folder/a";
        String path=classPath+absolutePath;

        File file1=new File(path);

        Map<String, Integer> map = new HashMap<>();
        count(file1,map);
        System.out.println(map);
    }

    private static void count(File file1, Map<String,Integer> map) {
        File[] listFiles = file1.listFiles();
        for (File listFile : listFiles) {
            if (listFile.isFile()){
                String[] split = listFile.getName().split("\\.");
                if (split.length>0){
                    String key=split[split.length-1];
                    if (map.containsKey(key)){
                        map.put(key,map.get(key)+1);
                    }else {
                        map.put(key,1);
                    }
                }
            }else{
                count(listFile,map);
            }
        }
    }


    private static void deleteAll(File file1) {
        File[] listFiles = file1.listFiles();
        for (File listFile : listFiles) {
            if (listFile.isDirectory()){
                deleteAll(listFile);
            }else {
                listFile.delete();
            }
        }
        //删除最后的文件夹
        file1.delete();
    }
}
