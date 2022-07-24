package kz.halykacademy.bookstore.genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreCreationDTO {

    private String name;

    public Genre toGenre() {

        return Genre.builder()
                .name(name)
                .build();
    }
}
