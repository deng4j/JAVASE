package dzh.com.tools.hutools.HTTP;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑槽号问题
 * http://10.2.0.36:30008/api/WMS/IssuedPickingTask
 */
public class HUACAO {

    private static String url;

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\temp\\work\\EXPORT.XLSX"), 0);

        List<List<Object>> readAll = reader.read();

        readAll.remove(0);
        System.out.println(readAll);


        List<JSONObject> bodyList =new ArrayList<>();
        for (List<Object> objects : readAll) {
            JSONObject jsonObject = JSONUtil.parseObj(objects.get(6).toString());
            JSONObject data = jsonObject.getJSONObject("data");

            JSONObject head = data.getJSONObject("head");
            head.put("sort_id","102");

            data.put("head",head);
            jsonObject.put("data",data);

            bodyList.add(jsonObject);
        }
        System.out.println(bodyList);

        url="https://www.baidu.com/";

//        for (JSONObject jsonObject : bodyList) {
//            String result = HttpRequest.post(url)
//                    .body(jsonObject.toString())
//                    .execute().body();
//            System.out.println(result);
//        }
    }
}
