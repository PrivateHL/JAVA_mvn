package Pattern.Iterator;

/**
 * @Description 具体的 迭代器实现
 * @Author Heling
 * @Date 2019/8/22 9:38
 **/
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf ;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public boolean hasNext() {
        if( index < bookShelf.getLength()){
            return true;
        }
        return false;
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index ++ ;
        return book;
    }
}
