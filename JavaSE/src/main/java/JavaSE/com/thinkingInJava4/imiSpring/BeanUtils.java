package JavaSE.com.thinkingInJava4.imiSpring;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;

/**
 * 专门用于创建各种对象，并对外提供方法
 * 1.集合用于存储创建的对象,<id,对象>
 * 2.静态代码块，集合初始化
 */

public class BeanUtils {
    private BeanUtils(){
    }
    private static HashMap<String,Object> hashMap=new HashMap<>();

    static {
        try {
        //使用类加载器,获取bean.xml的真实路径
        URL resource = ClassLoader.getSystemClassLoader().getResource("bean.xml");
        String path = resource.getPath();
        //使用jsoup对xml进行解析
            Document parse = Jsoup.parse(new File(path), "UTF-8");
            //根据标签名获取所有标签,Elements继承了ArrayList
            Elements beans = parse.getElementsByTag("bean");
            //遍历集合
            for (Element bean : beans) {
                //根据属性获取对应的值
                String id = bean.attr("id");
                String className = bean.attr("class");
                //使用反射根据属性创建对象，并存入集合
                Class<?> aClass = Class.forName(className);
                Constructor<?> con = aClass.getDeclaredConstructor();
                con.setAccessible(true);
                Object obj = con.newInstance();
                //拿到bean下的节点
                Elements propertys = bean.getElementsByTag("property");
                for (Element property : propertys) {
                    String fieldName = property.attr("fieldName");
                    String fieldValue = property.attr("fieldValue");
                    Field declaredField = aClass.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    if (declaredField.getType()==int.class){
                        declaredField.set(obj,Integer.valueOf(fieldValue));
                    }
                }
                //存入hashmap集合
                hashMap.put(id,obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    public static Object getBean(String id){
        if (hashMap.containsKey(id)){
            return hashMap.get(id);
        }
        return "null";
    }
}
