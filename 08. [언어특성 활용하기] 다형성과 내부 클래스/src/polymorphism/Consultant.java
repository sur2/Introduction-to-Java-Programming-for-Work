package polymorphism;

public class Consultant extends Employee {
	
	int tax = 0;
	
	public Consultant() {
		// TODO Auto-generated constructor stub
		this.tax = super.tax + 10;
	}
	
	@Override
	public void printTax() {
		System.out.println(tax);
	}
}
