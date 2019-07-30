package Pattern.builder;

public class MainBuilder {

	public static void main(String[] args){
		if(args.length != 1){
			usage();
			System.exit(0);
		}
		if(args[0].equalsIgnoreCase("plain")){
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.constrauct();
			String result = textbuilder.getResult();
			System.out.println(result);
		} else if(args[0].equalsIgnoreCase("html")){
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.constrauct();
			String filename = htmlbuilder.getResult();
			System.out.println(filename + "文件编写完成");
		} else if (args[0].equalsIgnoreCase("pro")){
			PropertyBuilder propertybuilder = new PropertyBuilder();
			Director director = new Director(propertybuilder);
			director.constrauct();
			String filename = propertybuilder.getResult();
			System.out.println(filename + "文件编写完成");
		}else{
			usage();
			System.exit(0);
		}
	}
	
	public static void usage(){
		System.out.println("Usage: java Main plain\t\t编写存文本文档");
		System.out.println("Usage: java Main html\t\t编写HTML文档");
	}
}
