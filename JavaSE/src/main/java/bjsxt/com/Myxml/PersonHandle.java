package bjsxt.com.Myxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class PersonHandle extends DefaultHandler {
    private ArrayList<person> persons;
    private person person;
    private String tag;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("处理文档开始");
        persons=new ArrayList<bjsxt.com.Myxml.person>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("处理文档结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("开始一个元素"+qName);
        if (qName!=null){
            tag=qName;
        }
        if (qName!=null&&qName.equals("person")){
            person=new person();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("结束一个元素"+qName);
        if (qName.equals("person")){
            this.persons.add(person);
        }
        tag=null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (tag!=null&&tag.equals("name")){
            person.setName(str);
        }else if (tag!=null&&tag.equals("age")){
            int age = Integer.parseInt(str);
            person.setAge(age);
        }
    }

    public ArrayList<bjsxt.com.Myxml.person> getPersons() {
        return this.persons;

    }
}
