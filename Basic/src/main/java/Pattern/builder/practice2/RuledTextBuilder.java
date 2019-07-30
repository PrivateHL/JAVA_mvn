package Pattern.builder.practice2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RuledTextBuilder extends RuledBuilder {


	private String filename;
	private PrintWriter writer;
	
	@Override
	protected void buildTitleString(String title) {
		// TODO Auto-generated method stub
		filename = title+".html";
		try{
			writer = new PrintWriter(new FileWriter(filename)); 
		}catch(IOException e){
			e.printStackTrace();
		}
		writer.println("<html><head><title>" + title + "</title></head><body>");
		writer.println("<h1>" + title +"</h1>");
	}
	@Override
	protected void buildString(String str) {
		// TODO Auto-generated method stub
		writer.println("<p>" + str + "</p>");
	}
	@Override
	protected void buildItems(String[] items) {
		// TODO Auto-generated method stub
		writer.println("<ul>");
		for(int i = 0; i < items.length; i++){
			writer.println("<li>" + items[i] + "</li>");
		}
		writer.println("</ul>");
	}
	@Override
	protected void buildDone() {
		// TODO Auto-generated method stub
		writer.println("</body></html>");
		writer.close();
	}
	
	public String getResult(){
		return filename;
	}
	
}
