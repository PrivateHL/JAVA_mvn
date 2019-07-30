package Pattern.factory;

import Pattern.factory.IDCard.IDCardFactory;
import Pattern.factory.framework.Factory;
import Pattern.factory.framework.Product;

public class MainFactoryPartern {

	public static void main(String[] args){
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("Ming");
		Product card2 = factory.create("Hong");
		Product card3 = factory.create("Gang");
		card1.use();
		card2.use();
		card3.use();
	}
}
