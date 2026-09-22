package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
        return (args) -> {

            Category scifi = crepository.save(new Category("Science Fiction"));
            Category classics = crepository.save(new Category("Classics"));
            crepository.save(new Category("Dystopian"));

            repository.save(new Book("Dune", "Frank Herbert", 1965, "9780441172719", 14.99, scifi));
            repository.save(new Book("Dune Messiah", "Frank Herbert", 1969, "9780593098233", 13.99, scifi));
        };
    }

}
