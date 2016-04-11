package demo.test;

public class Hello {
	public static void main(String[] args) {
		System.out.println("This is Hello class");
		World.testWorld();
		World.main(null);
	}
}

class World{
	public static void main(String[] args) {
		System.out.println("This is World class");
	}
	
	public static void testWorld(){
		System.out.println("This is testWorld method");
	}
}
