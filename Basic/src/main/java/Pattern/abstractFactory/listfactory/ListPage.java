package Pattern.abstractFactory.listfactory;

import java.util.Iterator;

import com.pattern.sample.abstractFactory.factory.Item;
import com.pattern.sample.abstractFactory.factory.Page;

public class ListPage extends Page{
	public ListPage(String title,String author){
		super(title, author);
	}

	@Override
	public String makeHTML() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><head><title>" + title + "</title></head>\n");
		buffer.append("<body>\n");
		buffer.append("<h1>" + title + "</h1>\n");
		buffer.append("<ul>\n");
		Iterator iter = content.iterator();
		while( iter.hasNext()){
			Item item = (Item) iter.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>\n");
		buffer.append("<hr><address>" + author + "</address>");
		buffer.append("</body></html>\n");
		return buffer.toString();
	}

}
