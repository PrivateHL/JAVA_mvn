package Pattern.prototype;

import com.pattern.sample.prototype.framework.Product;

public class UnderlinePen implements Product{

	private char ulchar;
	
	public UnderlinePen(char ulchar){
		this.ulchar = ulchar;
	}


	@Override
	public void use(String s) {
		// TODO Auto-generated method stub
		int len = s.getBytes().length;
		System.out.println("\"" + s + "\"");
		for (int i = 0; i < len+2 ; i++){
			System.out.print(ulchar);
		}
		System.out.println("");
	}

	@Override
	public Product createClone() {
		// TODO Auto-generated method stub
		Product p  = null;
		try {
			p = (UnderlinePen) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
