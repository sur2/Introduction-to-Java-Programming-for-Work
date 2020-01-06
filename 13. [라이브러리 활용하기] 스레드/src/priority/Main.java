package priority;

public class Main {
	public static void main(String[] args) {
		Food f = new Food();
		Phone p = new Phone();
		
		// 우선순위 phone이 먼저
		p.setPriority(Thread.MAX_PRIORITY);
		f.setPriority(Thread.MIN_PRIORITY);
	
		// f를 실행하여도 우선순위 높은 Phone 부터 실행
		f.start();
		p.start();
		
		// Main Thread가 가장 먼저 실행됨
		System.out.println("Main Thread");
	}
}

class Food extends Thread {
	
	public Food() {
		setName("Food");
	}
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + " : " + i);
		}
	}
}

class Phone extends Thread {
	
	public Phone() {
		setName("Phone");
	}
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + " : " + i);
		}
	}
}
