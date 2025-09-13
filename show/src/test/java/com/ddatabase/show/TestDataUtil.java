package com.ddatabase.show;

import com.ddatabase.show.dom.Author;
import com.ddatabase.show.dom.Book;

import static javax.print.attribute.standard.MediaSizeName.B;

public final class TestDataUtil {

    private TestDataUtil() {

    }

    public static Author getAuthor() {
        return Author.builder()

                .name("John")
                .age(56)
                .build();
    }

    public static Author getAuthorB() {
        return Author.builder()

                .name("John1")
                .age(5)
                .build();
    }

    public static Author getAuthorC() {
        return Author.builder()

                .name("pan")
                .age(6)
                .build();
    }

    public static Book getBook(final Author author) {
        return Book.builder()
                .isbn("dafe")
                .title("rich")
                .author(author)
                .build();
    }
    public static Book getBookB(final Author author) {
        return Book.builder()
                .isbn("dae")
                .title("1st")
                .author(author)
                .build();
    }
    public static Book getBookC(final Author author) {
        return Book.builder()
                .isbn("de")
                .title("money ")
                .author(author)
                .build();
    }
}
