package ����;

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
		System.out.println("���� Main Thread ProductAdd Thread�� join ��");
		
		// �����带 �̸� ���� Executors.newFixedThreadPool(����)
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		threadPool.execute(new ProductGet(pool));
		threadPool.execute(new ProductAdd(pool));
		threadPool.shutdown();
		
		// �������� �� ���� �����带 ������� �̸� ���� (����)
		Semaphore semaphore = new Semaphore(3);
		
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
		// �̸� ������ ������ ���� �����尡 �Ǿ����� ������ ���� �༮ ���� ���� �ִ´�.
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
		new SemaphoreThread(semaphore).start();
	}

}

class Pool {
	List<String> products = new LinkedList<String>(Arrays.asList("����", "���찳", "����", "������"));
	
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
				System.out.println(i + "�� ��ǰ " + product);
				System.out.println("��ǰ ��� �� ��� : " + pool.products.size());
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
			pool.add("��ǰ "+i);
			System.out.println("��ǰ�԰�!");
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
				System.out.println(getName() + " : " + i + "��  ° ���");
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Interrupt �߻�! Sleep �Լ� ����");
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
			// ���� ���� ���� ������ ī��Ʈ (+1)
			this.semaphore.acquire();
			System.out.println(getName());
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// ������� ������ ���� (-1)
			this.semaphore.release();
		}
	}
}

