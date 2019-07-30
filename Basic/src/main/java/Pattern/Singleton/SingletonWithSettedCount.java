package Pattern.Singleton;

public class SingletonWithSettedCount {

	private static SingletonWithSettedCount[]  singles = new  SingletonWithSettedCount[]{
			new SingletonWithSettedCount(0),
			new SingletonWithSettedCount(1),
			new SingletonWithSettedCount(2)
	};
	private int id;
	 private SingletonWithSettedCount(int id){ this.id = id;}
	 public static SingletonWithSettedCount getInsatnce(int id){
		 if(id >= 0 && id < 3){
			 return singles[id];
		 }
		 return null;
	 }
	 public String toString(){
		 return "SingletonWithSettedCount at " + id;
	 }
}
