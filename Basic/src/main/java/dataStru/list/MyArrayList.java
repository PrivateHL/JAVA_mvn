package dataStru.list;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> implements List<E>, Cloneable, Serializable {

    /** 空数组列表 **/
    private static final Object[] EMPTY_DATA = {};
    /** 默认的空数组列表 和EMPTY_DATA不同的是，为了区分初始化size为0还是没有初始化，在扩容的时候会有区别 **/
    private static final Object[] DEFALUT_EMPTY_DATA ={};//
    private static final int DEFALUT_INIT_SIZE = 8;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;//理想的最大数长度

    private int size = 0;
    Object[] data ;

    public MyArrayList() {
        data = EMPTY_DATA;
    }

    public MyArrayList(int initCapacity) {
        if( initCapacity > 0 ){
            data = new Object[initCapacity];
        }else if (initCapacity == 0){
            data = DEFALUT_EMPTY_DATA;
        }else{
            throw new InvalidParameterException("illegal Parameter " + this.getClass().getSimpleName() +
                    " initial Capacity cannot be " + initCapacity + " (smaller than zero)" );
        }
    }

    public MyArrayList(Collection<E> collection){
        data = collection.toArray();
        if( (size = data.length) != 0){
            if( data.getClass() != Object[].class ){//toArray可能是其他的类型的数组
                data = Arrays.copyOf(data,size,Object[].class );
            }
            data = DEFALUT_EMPTY_DATA;
        }else {
            data = EMPTY_DATA;
        }
    }

    @Override
    public boolean add(E e) {
        //toDo
        ensureCapacity(size + 1);

        data[ size++ ] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        //toDo
        return super.remove(index);
    }


    @Override
    public E get(int index) {
        checkIndex(index);

        return dataAt(index);
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int targetIndex){
        if(size <= targetIndex)
            throw new IndexOutOfBoundsException("index " + targetIndex + " out of range: " + size);
    }
    private E dataAt(int index){
        return (E) data[index];
    }

    private void ensureCapacity(int capacityRequired){
        ensureExplicitCapacity( calculateCapacity(data, capacityRequired));

    }

    private int calculateCapacity(Object[] data, int capacityRequired){
        if( data == DEFALUT_EMPTY_DATA ){
            return Math.max(DEFALUT_INIT_SIZE, capacityRequired);
        }
        return capacityRequired;
    }

    private void ensureExplicitCapacity(int capacityTarget){
        /** 增加修改次数标记，通知其他的修改操作，数据已被修改;
         * 检查容量是否扩容一般是添加元素才会检查，所以对修改次数控制增加到这里**/
        modCount++;//增加修改次数标记，通知其他的修改操作，数据已被修改
        if( capacityTarget > data.length ){
            growCapacity(capacityTarget);
        }
    }


    /**
     * 一次扩容命令，调用一次肯定会增加，至少增长一半的空间
     * @param capacityRequired
     */
    private void growCapacity(int capacityRequired){
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        newCapacity = Math.max(newCapacity,capacityRequired);
//        if( newCapacity - capacityRequired < 0) {
//            newCapacity = capacityRequired;
//        }

        if( newCapacity > MAX_ARRAY_SIZE )
            throw new OutOfMemoryError("MyArrayList out of max range");

//            Object[] newData = new Object[newCapacity];
//            newData = Arrays.copyOf(data,size,Object[].class);
//            data = newData;
        data = Arrays.copyOf(data, newCapacity);//还有这种扩容操作
        }
    }
}
