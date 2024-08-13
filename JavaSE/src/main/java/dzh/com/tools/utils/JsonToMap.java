package dzh.com.tools.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.JsonObject;


public class JsonToMap {
    public static void main(String[] args) {
        String str = "showLocation&&showLocation({\"status\":0,\"result\":{\"location\":{\"lng\":112.99374867242645,\"lat\":23.20905171274364},\"precise\":1,\"confidence\":80,\"comprehension\":100,\"level\":\"门址\"}})";

        str=str.replace("showLocation&&showLocation(","");

        JSONObject jsonObject = JSONUtil.parseObj(str);
//        System.out.println(jsonObject);

        Object result = jsonObject.get("result");

//        System.out.println(result);

        Object location = JSONUtil.parseObj(result).get("location");
//        System.out.println(location);

        JSONObject jsonNew = JSONUtil.parseObj(location);
        System.out.println(jsonNew.get("lng"));
        System.out.println(jsonNew.get("lat"));
    }
}
