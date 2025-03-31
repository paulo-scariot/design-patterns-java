package behavioral.iterador.example2;

import java.util.List;

public class Bookstore implements IterableCollection<Book> {
    private List<Book> books;

    public Bookstore(List<Book> books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookstoreIterator(this.books);
    }
}