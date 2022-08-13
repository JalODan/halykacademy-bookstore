package kz.halykacademy.bookstore.user;

import kz.halykacademy.bookstore.security.Authority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;


public enum Role {

    USER(Set.of(
            Authority.AUTHOR_READ,
            Authority.GENRE_READ,
            Authority.ORDER_READ,
            Authority.PUBLISHER_READ,
            Authority.BOOK_READ,
            Authority.ORDER_CREATE,
            Authority.USER_READ
    )),
    ADMIN(Set.of(
            Authority.BOOK_CREATE,
            Authority.BOOK_READ,
            Authority.BOOK_UPDATE,
            Authority.BOOK_DELETE,
            Authority.AUTHOR_CREATE,
            Authority.AUTHOR_READ,
            Authority.AUTHOR_UPDATE,
            Authority.AUTHOR_DELETE,
            Authority.GENRE_CREATE,
            Authority.GENRE_READ,
            Authority.GENRE_UPDATE,
            Authority.GENRE_DELETE,
            Authority.PUBLISHER_CREATE,
            Authority.PUBLISHER_READ,
            Authority.PUBLISHER_UPDATE,
            Authority.PUBLISHER_DELETE,
            Authority.ORDER_CREATE,
            Authority.ORDER_READ,
            Authority.ORDER_UPDATE_STATUS,
            Authority.USER_CREATE,
            Authority.USER_READ,
            Authority.USER_UPDATE,
            Authority.USER_DELETE
    ));

    private final Set<Authority> authorities;

    Role(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {

        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toSet());
    }
}
