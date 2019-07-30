package Pattern.builder.practice2;

/**
 * 新的要求 规定maketitle只调用一次
 * 并且在调用其他抽象方法之前已经调用过了makeTitle
 * @author Administrator
 *
 */
public abstract class RuledBuilder {

	/** 标记是否调用过makeTitle **/
	private boolean isMakedTitle = false;
	public void makeTitle(String title){
		if(!isMakedTitle){
			buildTitleString(title);
			isMakedTitle = true;
		}else{
			//return a exception
		}
	}
	public  void makeString(String str){
		if(isMakedTitle){
			buildString(str);
		}else{
			//trow a excption
		}
	}
	public  void makeItems(String[] items){
		if(isMakedTitle){
			buildItems(items);
		}else{
			//trow a excption
		}
	}
	public  void close(){
		if(isMakedTitle){
			buildDone( );
		}else{
			//trow a excption
		}
	}
	
	protected abstract void buildTitleString(String title);
	protected abstract void buildString(String str);
	protected abstract void buildItems(String[] items);
	protected abstract void buildDone();
}
