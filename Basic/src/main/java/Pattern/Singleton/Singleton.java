package Pattern.Singleton;

public class Singleton {

	private static Singleton singleton = new Singleton();
	private Singleton(){
		System.out.println("construct a Singleton." );
	}
	public static Singleton getInstance(){
		return singleton;
	}
}
