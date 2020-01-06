
public class Main {

	public static void main(String[] args) {
		Runnable runnable = new Thread(new Work1());
		Thread thread = new Thread(new Work2());
		
		runnable.run();
		thread.start();
		
	}

}

class Work1 extends Thread {
	public Work1() {
		setName("Work1의 작업");
	}
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(getId() + " : " + getName());
		}
	}
}

class Work2 extends Thread {
	public Work2() {
		setName("Work2의 작업");
	}
	
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(getId() + " : " + getName());
		}
	}
	
}
