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
		
		
		// Employee를 상속 받은 객체는 타입 파라메터가 일치한다.
		calTax(c);
		calTax(d);
		calTax(s);
		
	}
	
	// 다형성
	public static void calTax(Employee e) {
		e.printTax();
	}

}
