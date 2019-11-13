import interface_test.Message;

public class Other extends Employee implements Message{

	@Override
	void cal() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("¿ª´Â Á© ¹Ø");
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setLogin(boolean is) {
		// TODO Auto-generated method stub
		Message.super.setLogin(is);
	}
	
	private int setNumber() {
		return 0;
	}
}
