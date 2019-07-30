package Pattern.abstractFactory.listfactory;

import Pattern.abstractFactory.factory.Factory;
import Pattern.abstractFactory.factory.Link;
import Pattern.abstractFactory.factory.Page;
import Pattern.abstractFactory.factory.Tray;

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
