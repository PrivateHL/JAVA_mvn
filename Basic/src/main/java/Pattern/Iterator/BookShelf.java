package Pattern.Iterator;

import javax.swing.*;

/**
 * @Description 书架，是一个Book的集合
 * @Author Heling
 * @Date 2019/8/22 9:36
 **/
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index){
        return books[index];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last ++ ;
    }

    public int getLength(){
        return last;
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
