package kz.halykacademy.bookstore.providers;

import kz.halykacademy.bookstore.models.Publisher;

import java.util.Arrays;
import java.util.List;

public class PublisherProvider implements PublisherProviderInterface{

    private static List<Publisher> publishers = Arrays.stream(new Publisher[]{

            new Publisher(),
            new Publisher(),
            new Publisher()

    }).toList();

    @Override
    public List<Publisher> getAll() {
        return publishers;
    }
}
