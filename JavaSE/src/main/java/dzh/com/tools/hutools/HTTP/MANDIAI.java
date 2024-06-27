package dzh.com.tools.hutools.HTTP;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

public class MANDIAI {

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\temp\\work\\md.XLSX"), 0);

        List<List<Object>> readAll = reader.read();

        System.out.println(readAll);

        List<String> data = new ArrayList<>();
        for (List<Object> objects : readAll) {
            data.add(objects.get(0).toString());
        }
        System.out.println(data);


        String url1="http://192.168.7.113:2021/sapgate/ws/sapgate/srv/stock/stockBA.getSackgroupData.srv";

        for (String d : data) {

            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.set("text",d);
            jsonObject1.set("type","containerno");

            String result1 = HttpRequest.post(url1)
                    .header("Accept", "application/json")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                    .header("Connection", "keep-alive")
                    .header("Content-Length", "39")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("Cookie", "JSESSIONID=node0gg9uimjkkh94ba6g5q90pp1k7510927.node0")
                    .header("Host", "192.168.7.113:2021")
                    .header("Origin", "http://192.168.7.113:2021")
                    .header("Referer", "http://192.168.7.113:2021/sapgate/ws/sapgate/func/RF/SackconfirmFunc/app")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36 Edg/126.0.0.0")
                    .body(jsonObject1.toString())
                    .execute().body();
            System.out.println(result1);

            System.out.println("-------------------------------------------------");


            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.set("containerno",d);
            jsonObject2.set("isfull","1");

            String url2="http://192.168.7.113:2021/sapgate/ws/sapgate/srv/stock/stockBA.sackgroupConfirm.srv";

            String result2 = HttpRequest.post(url2)
                    .header("Accept", "application/json")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                    .header("Connection", "keep-alive")
                    .header("Content-Length", "39")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("Cookie", "JSESSIONID=node0gg9uimjkkh94ba6g5q90pp1k7510927.node0")
                    .header("Host", "192.168.7.113:2021")
                    .header("Origin", "http://192.168.7.113:2021")
                    .header("Referer", "http://192.168.7.113:2021/sapgate/ws/sapgate/func/RF/SackconfirmFunc/app")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36 Edg/126.0.0.0")
                    .body(jsonObject2.toString())
                    .execute().body();
            System.out.println(result2);

        }

    }
}
