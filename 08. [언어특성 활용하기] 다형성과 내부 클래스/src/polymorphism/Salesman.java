package polymorphism;

public class Salesman extends Employee {
	int tax = 0;
	
	public Salesman() {
		// TODO Auto-generated constructor stub
		this.tax = super.tax + 100;
	}
	
	@Override
	public void printTax() {
		System.out.println(tax);
	}
}
