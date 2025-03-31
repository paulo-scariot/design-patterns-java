package behavioral.iterador.example2;

import java.util.List;

public class Library implements IterableCollection<Book> {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> createIterator() {
        return new LibraryIterator(this.books);
    }
}
