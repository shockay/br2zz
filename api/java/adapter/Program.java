package adapter;

public class Program {

	public static void main(String[] args) {
		
		Target target = new Adapter();
		target.Request();
		
	}
}
