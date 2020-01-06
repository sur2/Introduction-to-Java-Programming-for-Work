package priority;

public class Main {
	public static void main(String[] args) {
		Food f = new Food();
		Phone p = new Phone();
		
		// �켱���� phone�� ����
		p.setPriority(Thread.MAX_PRIORITY);
		f.setPriority(Thread.MIN_PRIORITY);
	
		// f�� �����Ͽ��� �켱���� ���� Phone ���� ����
		f.start();
		p.start();
		
		// Main Thread�� ���� ���� �����
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
