package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.demo")
public class OneToManyRestApplication implements CommandLineRunner {

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

//	@Autowired
//	public OneToManyRestApplication(BookCategoryRepository bookCategoryRepository) {
//		
//		this.bookCategoryRepository = bookCategoryRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(OneToManyRestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		BookCategory categoryA = new BookCategory("OpenSource");
		Set<Book> bookAs = new HashSet<Book>() {
			{
				add(new Book("SCJP", categoryA));
				add(new Book("OCJP", categoryA));
				add(new Book("Spring 4", categoryA));
				add(new Book("Spring Coud", categoryA));
				add(new Book("Hytrix", categoryA));
			}
		};
		categoryA.setBooks(bookAs);

		Set<BookCategory> bSet = new HashSet<BookCategory>() {
			{
				add(categoryA);
			}
		};

		bookCategoryRepository.save(bSet);

		bookCategoryRepository.findAll().forEach(a -> System.out.println(a.toString()));

	}
}
