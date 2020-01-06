package synchronize;

public class Main {

	public static void main(String[] args) {
		
		Card card = new Card();
		
		Drawable d1 = new Drawable(card);
		Drawable d2 = new Drawable(card);
		
		d1.start();
		d2.start();
	}

}

class Card {
	private long balance = 1000;
	
	public Card() {

	}
	
	public synchronized void draw(long amount) {
		balance -= amount;
	}
	
	public long getBalance() {
		return balance;
	}
}

class Drawable extends Thread {
	
	Card card;
	
	public Drawable(Card card) {
		this.card = card;
	}
	@Override
	public void run() {
		super.run();
//		synchronized (card) {
			for (int i = 0; i < 10; i++) {
				card.draw(10);
				System.out.println("ภÜพื : "+card.getBalance());
			}
//		}
	}
}
