import interface_test.Message;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Other ot = new Other();
		
		ot.cal();
		ot.setLogin(true);
		
		// static���� �����Ͽ� code ������ �޸𸮰� ���� 
		// �޼��尡 �����Ǿ��� ������ new ���� �ٷ� ��� ����
		Message.setNumber();
	}

}
