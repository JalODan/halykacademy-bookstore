package kz.halykacademy.bookstore.Publisher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherCreationDTO {

    private String name;

    public Publisher toPublisher() {

        return Publisher.builder()
                .name(name)
                .build();
    }
}
