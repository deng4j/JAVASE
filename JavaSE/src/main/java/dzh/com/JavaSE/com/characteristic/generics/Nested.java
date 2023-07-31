package dzh.com.JavaSE.com.characteristic.generics;

public class Nested <T>{
	T stu ;

	public static void main(String[] args) {
		//泛型的嵌套
		Nested<Student<String>> room =new  Nested<Student<String>>();
		//从外到内拆分
		room.stu = new Student<String>();
		Student<String> stu = room.stu;
		String score =stu.score;
		System.out.println(score);
	}
}

class Student<T> {
	T score;
}

