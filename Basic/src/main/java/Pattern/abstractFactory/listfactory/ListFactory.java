package Pattern.abstractFactory.listfactory;

import com.pattern.sample.abstractFactory.factory.Factory;
import com.pattern.sample.abstractFactory.factory.Link;
import com.pattern.sample.abstractFactory.factory.Page;
import com.pattern.sample.abstractFactory.factory.Tray;

public class ListFactory extends Factory {
	public Link createLink(String caption, String url){
		return new ListLink(caption, url);
	}

	@Override
	public Page createPage(String title, String author) {
		// TODO Auto-generated method stub
		return new ListPage(title, author);
	}

	@Override
	public Tray createTray(String caption) {
		// TODO Auto-generated method stub
		return new ListTray(caption);
	}

}
