package dzh.com.tools.hutools.HTTP;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.io.UnsupportedEncodingException;

public class GET {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url1=String.format("https://api.map.baidu.com/geocoding/v3/?address=%s&output=json&ak=njzy4tat1oG38dQ7NlFGlhG3lY1U7SS0&callback=showLocation","佛山市南海区狮山镇红沙高新技术开发区前进中路2号");
        System.out.println(url1);
        HttpResponse execute = HttpRequest.get(url1).timeout(5 * 1000).execute();
        System.out.println(execute.body());

    }
}
