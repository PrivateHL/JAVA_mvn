package Pattern.factory.IDCardWithCode;

import com.pattern.sample.factory.framework.Product;

public class IDCard extends Product{

	private String owner;
	private int serial;
	
	IDCard(String owner,int serial){
		System.out.println("MAKE " + owner + "'s IDCard with Code: " + serial);
		this.owner = owner;
		this.serial = serial;
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("USE " + owner + "'s IDCard with Code: " + serial);
	}
	
	public String getOwner(){
		return owner;
	}
	
	public int getSerial(){
		return serial;
	}

}
