package dzh.com.tools.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 给数据列添加引号和逗号
public class StrAddQuotationMarks {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\邓志鸿\\Desktop\\temp.txt";
        File file = new File(path);
        if (!file.exists()){
            System.out.println("创建文件："+path);
            file.createNewFile();
        }

        List<String> list = new ArrayList<>();

        System.out.println("读取内容中...");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String str;
        while (null!=(str=br.readLine())){
            if (str.length()>0){
                list.add(str);
            }
        }

        StringBuilder newdata = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i==list.size()-1){
                newdata.append("\'"+list.get(i)+"\'");
            }else {
                newdata.append("\'"+list.get(i)+"\',");
            }
        }
        br.close();
        System.out.println("读取完毕");

        // 清空文件
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
        System.out.println("清空文件");

        // 写入内容
        System.out.println("写入内容中...");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        bw.write(newdata.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("写入完毕");
    }
}
