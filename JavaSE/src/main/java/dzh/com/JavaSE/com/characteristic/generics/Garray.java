package dzh.com.JavaSE.com.characteristic.generics;

/**
 * 没有泛型数组
 * 声明可以使用，但是创建失败
 * @author Administrator
 *
 */
public class Garray {

	public static void main(String[] args) {
		MyArrayList<String> strList =new MyArrayList<String>();
		strList.add(0, "a");
		String elem =strList.getElem(0);
		System.out.println(elem);
	}

}

class MyArrayList<E>{
	//E[] cap =new E[10]; 没有泛型数组
	Object[] cap = new Object[10];
	E[] newcap= (E[]) cap;

	public void add(int idx,E e){
		cap[idx] =e;
	}


	@SuppressWarnings("unchecked")
	public E[] getAll(){
		return (E[]) cap;
	}
	@SuppressWarnings("unchecked")
	public E getElem(int idx){
		return (E) cap[idx];
	}
}
