package Pattern.abstractFactory.factory;

public class Main {

	public static void main (String[] args){
		if(args.length != -1){
			System.out.println("Usage: Java main class.name.of.concreteFactory");
			System.out.println("Example 1: java main listfactory.ListFactory" );
			System.out.println("Exmaple 2: java main tablefactory.TableFactory");
			System.exit(0);
		}
		Factory factory = Factory.getFactory(args[0]);
		
		Link people = factory.createLink("�����ձ�", "http://www.people.com.cn/");
		Link gmw = factory.createLink("�����ձ�", "http:/www.gmw.cn/");
		
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("jp_yahoo!Japan", "http://www.yahoo.co.jp/");
		Link excite = factory.createLink("excite!", "http://www.excite.com/");
		Link google = factory.createLink("google!", "http://www.google.com/");
		
		Tray traynews = factory.createTray("�ձ�");
		traynews.add(people);
		traynews.add(gmw);
		
		Tray trayyahoo = factory.createTray("Yahoo!");
		traynews.add(us_yahoo);
		traynews.add(jp_yahoo);
		
		Tray traysearch = factory.createTray("��������");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);
		
		Page page = factory.createPage("LinkPage", "����");
		page.add(traynews);
		page.add(traysearch);
		page.output();
	}
}
