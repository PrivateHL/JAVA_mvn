package Pattern.factory.IDCard;

import java.awt.List;
import java.util.ArrayList;

import Pattern.factory.framework.Factory;
import Pattern.factory.framework.Product;

public class IDCardFactory extends Factory {

	private ArrayList owners = new ArrayList();
	@Override
	protected Product createProduct(String owner) {
		// TODO Auto-generated method stub
		return new IDCard(owner);
	}

	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		owners.add(((IDCard)product).getOwner());
	}
	public ArrayList getOwners(){
		return owners;
	}

}
