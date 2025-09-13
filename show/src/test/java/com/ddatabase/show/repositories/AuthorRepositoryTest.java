package com.ddatabase.show.repositories;

import com.ddatabase.show.TestDataUtil;
import com.ddatabase.show.dom.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest



@ExtendWith(SpringExtension.class) // ensures each test runs in a transaction that's rolled back after the test
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository underTest;

    @Test
    public void testIntegration() {
        Author author = TestDataUtil.getAuthor();
        underTest.save(author);

        Optional<Author> result = underTest.findById(author.getId()); // keep your DAO method name
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testMultipleAuthorsCanBeCreatedAndRead() {
        Author author = TestDataUtil.getAuthor();
        Author author2 = TestDataUtil.getAuthorB();
        Author author3 = TestDataUtil.getAuthorC();

        underTest.save(author);
        underTest.save(author2);
        underTest.save(author3);

        Iterable<Author> result = underTest.findAll(); // keep your DAO method name

        // check size and contents (order-insensitive)
        assertThat(result).hasSize(3)
                .containsExactlyInAnyOrder(author, author2, author3);
    }
    @Test
    void testupdateIntegrtion() {
        Author author = TestDataUtil.getAuthor();
        underTest.save(author);
        author.setName("George");
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }
    @Test
    void testdeleteIntegrtion() {
        Author author = TestDataUtil.getAuthor();
        underTest.save(author);
        underTest.deleteById(author.getId());
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }
}
