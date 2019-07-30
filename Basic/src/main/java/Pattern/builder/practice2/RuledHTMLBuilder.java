package Pattern.builder.practice2;

public class RuledHTMLBuilder extends RuledBuilder {


	private StringBuffer buffer = new StringBuffer();

	@Override
	protected void buildTitleString(String title) {
		// TODO Auto-generated method stub
		buffer.append("=============================\n");
		buffer.append("¡¾" + title + "¡¿\n");
		buffer.append("\n");
	}

	@Override
	protected void buildString(String str) {
		// TODO Auto-generated method stub
		buffer.append("#" + str + "\n");
		buffer.append("\n");
	}

	@Override
	protected void buildItems(String[] items) {
		// TODO Auto-generated method stub
		for(int i = 0; i < items.length; i++){
			buffer.append("\t." + items[i] + "\n");
		}
		buffer.append("\n");
	}

	@Override
	protected void buildDone() {
		// TODO Auto-generated method stub
		buffer.append("===========================\n");
	}

	public String getResult(){
		return buffer.toString();
	}
	
}
