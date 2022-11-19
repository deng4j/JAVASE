package JavaSE.com.Collection.list.linkedlist.MyLinkedList;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.add("a");
        list.add("b");
        String s= list.get(0);
        System.out.println(s);
    }

    private  void rangeIndex(int index){
        if (index<0||index>=size){
            try {
                throw  new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private String get(int index) {
        rangeIndex(index);
        if (index<(size>>1)){
            Node x=first;
            for (int i=0;i<index;i++){
                x=x.getNext();
            }
            return (String) x.getValue();
        }else {
            Node x=last;
            for (int i=size-1;i>index;i--){
                x=x.getPrevious();
            }
            return (String) x.getValue();
        }
    }

    private void add(Object value) {
        Node node=new Node();
        if (null==first){
            node.setPrevious(null);
            node.setValue(value);
            node.setNext(null);

            //赋值后二者地址一样
            first=node;
            last=node;
        }else {
            node.setPrevious(last);
            node.setValue(value);
            node.setNext(null);
            //由于first和last地址一样
            last.setNext(node);
            //last临时存储上一个节点对象
            last=node;
        }
        size++;
    }
}
