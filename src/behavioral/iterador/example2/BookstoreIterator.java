package behavioral.iterador.example2;

import java.util.List;

public class BookstoreIterator implements Iterator<Book> {
    private List<Book> books;
    private int index;

    public BookstoreIterator(List<Book> books) {
        this.books = books;
        this.index = books.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Book next() {
        return hasNext() ? books.get(index--) : null;
    }
}
