package kz.halykacademy.bookstore.security;

public enum Authority {

    BOOK_CREATE("book_create"),
    BOOK_READ("book:read"),
    BOOK_UPDATE("book:update"),
    BOOK_DELETE("book:delete"),
    AUTHOR_CREATE("author_create"),
    AUTHOR_READ("author:read"),
    AUTHOR_UPDATE("author:update"),
    AUTHOR_DELETE("author:delete"),
    GENRE_CREATE("genre_create"),
    GENRE_READ("genre:read"),
    GENRE_UPDATE("genre:update"),
    GENRE_DELETE("genre:delete"),
    PUBLISHER_CREATE("publisher_create"),
    PUBLISHER_READ("publisher:read"),
    PUBLISHER_UPDATE("publisher:update"),
    PUBLISHER_DELETE("publisher:delete"),
    ORDER_CREATE("order:create"),
    ORDER_READ("order:read"),
    ORDER_UPDATE_STATUS("order:update_status"),
    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");

    private final String name;

    Authority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
