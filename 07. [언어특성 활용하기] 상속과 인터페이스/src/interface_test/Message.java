package interface_test;

public interface Message {
	public String getMessage();
	
	// java8 ���� �߰����
	public default void setLogin(boolean is) {
		System.out.println("�������̽� �޼��忡 �ٵ� ������ �ִ�.");
	}
	
	public static int setNumber() {
		System.out.println("�������̽� static");
		return 10;
	}
}
