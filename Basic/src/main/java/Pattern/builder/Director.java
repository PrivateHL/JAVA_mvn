package Pattern.builder;

public class Director {

	private Builder builder;
	public Director (Builder builder){
		this.builder = builder;
	}
	
	public void constrauct(){
		builder.makeTitle("Greeting");
		builder.makeString("from morning to afternoon");
		builder.makeItems(new String[]{
				"Good mornig.",
				"Good afternoon."
		});
		builder.makeString("evening");
		builder.makeItems(new String[]{
				"Good evenig.",
				"Good night.",
				"Goodbye."
		});
		builder.close();
	}
}
