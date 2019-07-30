package Pattern.prototype;

import com.pattern.sample.prototype.framework.Manager;
import com.pattern.sample.prototype.framework.Product;

public class MainPrototype {

	public static void main(String[] args){
		//prepare
		Manager manager = new Manager();
		UnderlinePen ulpen = new UnderlinePen('~');
		MessageBox box1 = new MessageBox('*');
		MessageBox box2 = new MessageBox('/');
		manager.register("Underline pen", ulpen);
		manager.register("Strong box", box1);
		manager.register("Warning box", box2);
		
		//clone produce
		Product p1 = manager.create("Underline pen");
		p1.use("HELLO, WORLD.");
		Product p2 = manager.create("Strong box");
		p2.use("HELLO, WORLD.");
		Product p3 = manager.create("Warning box");
		p3.use("HELLO, WORLD.");
	}
}
