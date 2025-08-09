package main;


public class Main {
	
	static HotelController controller = new HotelController();
	
	public static void main(String[] args) {
		start();

	}
	
	static void start() {
		MainGUI mgu=new MainGUI(controller);
		mgu.show();
	}
}
