import object.A;
import object2.B;

public class Test01 extends A{
	static {
		System.out.println("이 녀석은 main과 같은 클래스의 static");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		B b = new B();
		A a = new A();
		a.print();

	}

}
