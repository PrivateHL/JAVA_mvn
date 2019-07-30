package Pattern.prototype.framework;

/**
 * Cloneable 被称为标记接口，标记类是否可以使用clone方法
 * clone方法实现是来自于Object类，但是被标记的类才可以使用。
 * field-to-field-clone浅复制，只复制字段值，数组指针值会被复制，指向同一个地址，容易导致错误。
 * @author Administrator
 *
 */
public interface Product extends Cloneable{

	//public abstract void use(String s);
	//public abstract Product createClone();
	void use(String s);
	Product createClone();

}
