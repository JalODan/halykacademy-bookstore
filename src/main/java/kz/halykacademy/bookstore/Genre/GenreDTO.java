package kz.halykacademy.bookstore.Genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {

    private Long id;
    private String name;

    public GenreDTO(Genre genre) {

        this.id = genre.getId();
        this.name = genre.getName();
    }
}
