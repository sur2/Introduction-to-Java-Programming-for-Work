import interface_test.Message;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Other ot = new Other();
		
		ot.cal();
		ot.setLogin(true);
		
		// static으로 생성하여 code 영역에 메모리가 있음 
		// 메서드가 구현되었기 때문에 new 없이 바로 사용 가능
		Message.setNumber();
	}

}
