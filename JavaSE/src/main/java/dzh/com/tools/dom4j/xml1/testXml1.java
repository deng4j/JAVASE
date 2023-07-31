package dzh.com.tools.dom4j.xml1;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class testXml1 {
    public static void main(String[] args) throws DocumentException {
        //获取一个解析对象
        SAXReader saxReader=new SAXReader();
        //加载xml文件到内存，并获得一个dom对象
        Document document = saxReader.read(new File("D:/idea/javas/src/com/XML/student.xml"));
        //得到根元素:<students>
        Element rootElement = document.getRootElement();
        /**
         * <student id="1">
         *  elements():可以获取调用者所有的子标签.会把这些子标签放到一个集合中返回.
         *  elements("标签名"):可以获取调用者所有的指定的子标签,会把这些子标签放到一个集合中并返回
         */
        List<Element> studentElement = rootElement.elements("student");

        for (Element element : studentElement) {
            //获取student的属性
            Attribute idAttribute = element.attribute("id");
            String idValue = idAttribute.getValue();
            System.out.println(idValue);
            //获取name
            Element name = element.element("name");
            String nameValue = name.getText();
            System.out.println(nameValue);
            //获取age
            Element age = element.element("age");
            String ageValue = age.getText();
            System.out.println(ageValue);
            System.out.println("---------------------");
        }




    }
}
