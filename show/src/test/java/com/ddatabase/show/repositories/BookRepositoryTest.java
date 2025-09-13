package com.ddatabase.show.repositories;

import com.ddatabase.show.TestDataUtil;
import com.ddatabase.show.dom.Author;
import com.ddatabase.show.dom.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository underTest;
    @Autowired
    private AuthorRepository authorRepository;



    @Test
    void testBookIntegration() {
        // Create and insert an author
        Author author = TestDataUtil.getAuthor();

        Book book = TestDataUtil.getBook(author);
        underTest.save(book);

        // Retrieve the book by title
        Optional<Book> result = underTest.findById(book.getIsbn());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(book.getIsbn(), result.get().getIsbn());
    }

    @Test
    void testReadMultipleBooks() {
        // Create and insert an author
        Author author = TestDataUtil.getAuthor();
        authorRepository.save(author);

        // Create multiple books with same author
        Book book1 = TestDataUtil.getBook(author);
        Book book2 = TestDataUtil.getBookB(author);
        Book book3 = TestDataUtil.getBookC(author);

        // Save the books
        underTest.save(book1);
        underTest.save(book2);
        underTest.save(book3);

        // Retrieve all books
        Iterable<Book> result = underTest.findAll();

        // Assertions
        assertThat(result).hasSize(3);
        assertThat(result).containsExactlyInAnyOrder(book1, book2, book3);
    }


    @Test
    void testupdatebookintegration() {
        Author author = authorRepository.save(TestDataUtil.getAuthor());
        Book book = TestDataUtil.getBook(author);
        underTest.save(book);
        book.setTitle("WWE CHAMPIONS");
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(book);

    }

    @Test
    void testdeletebookintegration()
    {
        Author author = TestDataUtil.getAuthor();
        Book book = TestDataUtil.getBook(author);
        underTest.deleteById(book.getIsbn());
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result.isEmpty());

    }
}

