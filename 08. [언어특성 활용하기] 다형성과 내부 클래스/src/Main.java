import polymorphism.Consultant;
import polymorphism.Director;
import polymorphism.Employee;
import polymorphism.Salesman;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consultant c = new Consultant();
		Director d = new Director();
		Salesman s = new Salesman();
		
		
		// Employee�� ��� ���� ��ü�� Ÿ�� �Ķ���Ͱ� ��ġ�Ѵ�.
		calTax(c);
		calTax(d);
		calTax(s);
		
	}
	
	// ������
	public static void calTax(Employee e) {
		e.printTax();
	}

}
