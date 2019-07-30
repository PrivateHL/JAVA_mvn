package Pattern.prototype;

import Pattern.prototype.framework.Product;

public class MessageBox implements Product{

	private char decochar;
	public MessageBox(char decochar){
		this.decochar = decochar;
	}
 
	public Product createClone() {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			product = (Product) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	public void use(String s) {
		// TODO Auto-generated method stub
		int length = s.getBytes().length;
		for(int i = 0; i < length + 4; i++){
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + " " + s + " " + decochar);
		for(int i = 0; i < length + 4; i++){
			System.out.print(decochar);
		}
		System.out.println("");
	}
	
	public void setDecochar(char decochar){
		this.decochar = decochar;
	}

}
