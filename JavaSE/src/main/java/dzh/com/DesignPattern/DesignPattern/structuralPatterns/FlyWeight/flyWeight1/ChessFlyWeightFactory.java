package dzh.com.DesignPattern.DesignPattern.structuralPatterns.FlyWeight.flyWeight1;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory（享元工厂类）：享元工厂类用于创建并管理享元对象，它针对抽象享元 类编程，将各种类型的具体享元对象存储在一个享元池中，
 * 享元池一般设计为一个存储“键值 对”的集合（也可以是其他类型的集合），可以结合工厂模式进行设计；
 * 当用户请求一个具体 享元对象时，享元工厂提供一个存储在享元池中已创建的实例或者创建一个新的实例（如果 不存在的话），返回新创建的实例并将其存储在享元池中。
 */
public class ChessFlyWeightFactory {
    /**
     * 享元池
     */
    private static Map<String,ChessFlyWeight> map=new HashMap<>();

    public static ChessFlyWeight getChess(String color){
        if (map.get(color)!=null){
            return map.get(color);
        }else {
            ChessFlyWeight cfw=new ConcreteChess(color);
            map.put(color,cfw);
            return cfw;
        }
    }


}
