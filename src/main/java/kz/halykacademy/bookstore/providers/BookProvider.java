package kz.halykacademy.bookstore.providers;

import kz.halykacademy.bookstore.models.Book;

import java.util.Arrays;
import java.util.List;

public class BookProvider implements BookProviderInterface{

    private static List<Book> books = Arrays.stream(new Book[]{
            new Book(),
            new Book(),
            new Book()
    }).toList();

    @Override
    public List<Book> getAll() {
        return books;
    }
}
