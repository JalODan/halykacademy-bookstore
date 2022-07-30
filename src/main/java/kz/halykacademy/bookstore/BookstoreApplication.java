package kz.halykacademy.bookstore;

import kz.halykacademy.bookstore.user.User;
import org.mapstruct.control.MappingControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
