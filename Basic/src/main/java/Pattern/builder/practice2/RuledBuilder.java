package Pattern.builder.practice2;

/**
 * �µ�Ҫ�� �涨maketitleֻ����һ��
 * �����ڵ����������󷽷�֮ǰ�Ѿ����ù���makeTitle
 * @author Administrator
 *
 */
public abstract class RuledBuilder {

	/** ����Ƿ���ù�makeTitle **/
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
