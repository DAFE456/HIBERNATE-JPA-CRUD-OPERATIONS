package com.ddatabase.show.repositories;

import com.ddatabase.show.dom.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    // You can add custom query methods here if needed
}
