package Pattern.factory.IDCard;

import com.pattern.sample.factory.framework.Product;

public class IDCard extends Product {

	private String owner;
	IDCard(String owner){
		System.out.println("MAKE " + owner + "'s IDCard.");
		this.owner = owner;
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("USE " + owner +"'s IDCard");
	}
	public String getOwner(){
		return owner;
	}
	
}
