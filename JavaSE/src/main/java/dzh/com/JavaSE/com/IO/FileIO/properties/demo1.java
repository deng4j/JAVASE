package dzh.com.JavaSE.com.IO.FileIO.properties;

import java.util.Properties;
import java.util.Set;

/**
 * 可以保存到流中或流中加载
 * 继承hashtable，与hashmap方法基本一致
 *load将本地文件中的键值对数据读取到集合中
 * store将集合中的数据以键值对保存到本地文件
 */
public class demo1 {
    public static void main(String[] args) {
        Properties props=new Properties();
        //setProperty与put一样
        props.setProperty("唐僧","江燕玲");
        props.put("猪八戒","高翠花");
        System.out.println(props);
        //stringPropertyNames与keyset一样
        Set<String> strProps = props.stringPropertyNames();


    }
}
