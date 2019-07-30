package Pattern.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PropertyBuilder extends Builder{
	
	private String filename ;
	private PrintWriter writer;

	@Override
	public void makeTitle(String title) {
		// TODO Auto-generated method stub
		filename = title+".properties";
		try{
			writer = new PrintWriter(new FileWriter(filename)); 
		}catch(IOException e){
			e.printStackTrace();
		}
		writer.println("//## STRAT" );
		writer.println("/**" + title + "**/");
		writer.println();
	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		writer.println("//" + str );
	}

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
		//writer.println("<ul>");
		for(int i = 0; i < items.length; i++){
			writer.println("" + items[i] + "");
		}
		//writer.println("</ul>");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		writer.println("//##END");
		writer.close();
	}

	public String getResult(){
		return filename;
	}
}
