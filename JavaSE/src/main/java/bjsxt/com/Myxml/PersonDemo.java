package bjsxt.com.Myxml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class PersonDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2从解析工厂获取解析器
        SAXParser parser=factory.newSAXParser();
        //3.加载文档document注册处理器
        //4.编写处理器
        PersonHandle personHandle=new PersonHandle();
        parser.parse(Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("bjsxt/com/Myxml/person.xml"),
                personHandle);
        ArrayList<person> persons=  personHandle.getPersons();
        System.out.println(persons.toString().toString());
    }
}
