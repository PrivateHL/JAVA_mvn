package Pattern.Iterator;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/22 10:02
 **/
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Q"));
        bookShelf.appendBook(new Book("WWW"));
        bookShelf.appendBook(new Book("ny"));
        bookShelf.appendBook(new Book("yy"));
        Iterator it = bookShelf.iterator();
        while(it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
