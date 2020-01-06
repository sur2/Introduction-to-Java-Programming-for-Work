package 제어;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class Main {

	public static void main(String[] args) {
		Pool pool = new Pool();

		Thread productAdd = new Thread(new ProductAdd(pool));
		Thread productGet = new Thread(new ProductGet(pool));
		
		productGet.start();
		productAdd.start();
		
		
		try {
			productAdd.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintThread printThread = new PrintThread();
		printThread.start();
		printThread.interrupt();
		System.out.println("나는 Main Thread ProductAdd Thread와 join 중");
		
		// 스레드를 미리 생성 Executors.newFixedThreadPool(개수)
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		threadPool.execute(new ProductGet(pool));
		threadPool.execute(new ProductAdd(pool));
		threadPool.shutdown();
		
		// 세마포어 몇 개의 스레드를 사용할지 미리 설정 (개수)
		Semaphore semaphore = new Semaphore(3);
		
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
		// 미리 설정한 개수에 먼저 스레드가 실어지고 수행이 끝난 녀석 부터 새로 넣는다.
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
	}

}

class Pool {
	List<String> products = new LinkedList<String>(Arrays.asList("연필", "지우개", "볼펜", "형광펜"));
	
	public synchronized String get() throws InterruptedException {
		while (products.size() == 0) {
			wait();
		}
		
		return products.remove(0);
	}
	
	public synchronized void add(String value) {
		products.add(value);
		notifyAll();
	}
}

class ProductGet implements Runnable {
	Pool pool;
	
	public ProductGet(Pool pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				String product = pool.get();
				System.out.println(i + "번 상품 " + product);
				System.out.println("상품 출고 후 재고 : " + pool.products.size());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ProductAdd implements Runnable {
	Pool pool;
	public ProductAdd(Pool pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			pool.add("상품 "+i);
			System.out.println("상품입고!");
		}
	}
}

class PrintThread extends Thread{
	
	public PrintThread() {
		setName("Print");
	}
	
	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
				System.out.println(getName() + " : " + i + "번  째 출력");
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Interrupt 발생! Sleep 함수 종료");
				break;
			}
		}
	}
}

class SemaphoreThread extends Thread {
	private Semaphore semaphore;
	
	public SemaphoreThread(Semaphore semaphore) {
		setName(this.toString());
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			// 현재 실행 중인 스레드 카운트 (+1)
			this.semaphore.acquire();
			System.out.println(getName());
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 사용중인 스레드 해제 (-1)
			this.semaphore.release();
		}
	}
}

