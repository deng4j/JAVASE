package dzh.com.tools.gzmpc.IWCS;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackEWMTaskResult {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\13539\\Desktop\\temp.txt";
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("创建文件：" + path);
            file.createNewFile();
        }

        List<String> list = new ArrayList<>();

        System.out.println("读取内容中...");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while (null != (str = br.readLine())) {
            if (str.length() > 0) {
                list.add(str);
            }
        }
        br.close();
        System.out.println("读取完毕");

        String url = String.format("http://10.2.0.36:30008/api/WCS/FeedbackEWMTaskResult?taskId=");

        for (String taskID : list) {
            String tempURl = url + taskID;
            System.out.println(tempURl);

            HttpResponse execute = HttpRequest.post(tempURl).timeout(5 * 1000).execute();
            System.out.println(execute.body());

        }
    }
}
