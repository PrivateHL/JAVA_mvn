package Pattern.factory.IDCardWithCode;

import java.util.HashMap;
import java.util.Hashtable;

import com.pattern.sample.factory.framework.Factory;
import com.pattern.sample.factory.framework.Product;

public class IDCardFactory extends Factory{
	private HashMap database = new HashMap();
	private int serial = 100;
	

	@Override
	protected synchronized Product createProduct(String owner) {
		// TODO Auto-generated method stub
		return new IDCard(owner, serial++);
	}

	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		IDCard card = (IDCard) product;
		database.put(new Integer(card.getSerial()),card.getOwner());
	}
	
	public HashMap getDatabase(){
		return database;
	}

}
