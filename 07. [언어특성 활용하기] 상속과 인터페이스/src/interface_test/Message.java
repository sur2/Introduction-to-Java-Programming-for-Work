package interface_test;

public interface Message {
	public String getMessage();
	
	// java8 부터 추가기능
	public default void setLogin(boolean is) {
		System.out.println("인터페이스 메서드에 바디를 가지고 있다.");
	}
	
	public static int setNumber() {
		System.out.println("인터페이스 static");
		return 10;
	}
}
