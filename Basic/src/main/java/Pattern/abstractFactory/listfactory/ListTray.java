package Pattern.abstractFactory.listfactory;

import java.util.Iterator;

import com.pattern.sample.abstractFactory.factory.Item;
import com.pattern.sample.abstractFactory.factory.Tray;

public class ListTray extends Tray{
	public ListTray(String caption){
		super(caption);
	}
	
	public String makeHTML(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<li>\n");
		buffer.append(caption + "\n");
		buffer.append("<ul>\n");
		Iterator iter = tray.iterator();
		while (iter.hasNext()){
			Item item = (Item) iter.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		return buffer.toString();
	}

}
