package polymorphism;

public class Director extends Employee{
	
	int tax = 0;
	
	public Director() {
		// TODO Auto-generated constructor stub
		this.tax = super.tax + 30;
	}
	
	@Override
	public void printTax() {
		System.out.println(tax);
	}

}
