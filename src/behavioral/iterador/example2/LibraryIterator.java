package behavioral.iterador.example2;

import java.util.List;

public class LibraryIterator implements Iterator<Book> {
    private List<Book> books;
    private int index = 0;

    public LibraryIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Book next() {
        return hasNext() ? books.get(index++) : null;
    }
}