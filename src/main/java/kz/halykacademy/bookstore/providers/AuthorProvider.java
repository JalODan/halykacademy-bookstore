package kz.halykacademy.bookstore.providers;

import kz.halykacademy.bookstore.models.Author;

import java.util.Arrays;
import java.util.List;

public class AuthorProvider implements AuthorProviderInterface{

    private static List<Author> authors = Arrays.stream(new Author[]{

            new Author(),
            new Author(),
            new Author()
    }).toList();

    @Override
    public List<Author> getAll() {
        return authors;
    }
}
