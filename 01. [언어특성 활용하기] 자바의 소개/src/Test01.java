import object.A;
import object2.B;

public class Test01 extends A{
	static {
		System.out.println("�� �༮�� main�� ���� Ŭ������ static");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		B b = new B();
		A a = new A();
		a.print();

	}

}
