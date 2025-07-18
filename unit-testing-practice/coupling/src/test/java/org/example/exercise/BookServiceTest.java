package org.example.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }
    @Test
    void testBorrowBook_Success() {
        Book book = new Book("1", "Title", "Author");
        when(bookRepository.findById("1")).thenReturn(book);

        Book result = bookService.borrowBook("1");

        assertFalse(result.isAvailable());
        verify(bookRepository).save(book);
    }

    @Test
    void testBorrowBook_NotFound() {
        when(bookRepository.findById("1")).thenReturn(null);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> bookService.borrowBook("1"));
        assertEquals("Book not found", ex.getMessage());
    }

    @Test
    void testBorrowBook_AlreadyBorrowed() {
        Book book = new Book("1", "Title", "Author");
        book.setAvailable(false);
        when(bookRepository.findById("1")).thenReturn(book);

        Exception ex = assertThrows(IllegalStateException.class, () -> bookService.borrowBook("1"));
        assertEquals("Book is already borrowed", ex.getMessage());
    }

    @Test
    void testReturnBook_Success() {
        Book book = new Book("2", "Title2", "Author2");
        book.setAvailable(false);
        when(bookRepository.findById("2")).thenReturn(book);

        Book result = bookService.returnBook("2");

        assertTrue(result.isAvailable());
        verify(bookRepository).save(book);
    }

    @Test
    void testReturnBook_NotFound() {
        when(bookRepository.findById("2")).thenReturn(null);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> bookService.returnBook("2"));
        assertEquals("Book not found", ex.getMessage());
    }

    @Test
    void testReturnBook_AlreadyAvailable() {
        Book book = new Book("2", "Title2", "Author2");
        book.setAvailable(true);
        when(bookRepository.findById("2")).thenReturn(book);

        Exception ex = assertThrows(IllegalStateException.class, () -> bookService.returnBook("2"));
        assertEquals("Book was not borrowed", ex.getMessage());
    }

    @Test
    void testFindAvailableBooksByAuthor() {
        Book book1 = new Book("1", "Title1", "AuthorA");
        Book book2 = new Book("2", "Title2", "AuthorB");
        Book book3 = new Book("3", "Title3", "AuthorA");

        when(bookRepository.findAllAvailableBooks()).thenReturn(Arrays.asList(book1, book2, book3));

        List<Book> result = bookService.findAvailableBooksByAuthor("AuthorA");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(book -> book.getAuthor().equals("AuthorA")));
    }

    @Test
    void testFindAvailableBooksByAuthor_Empty() {
        when(bookRepository.findAllAvailableBooks()).thenReturn(Collections.emptyList());

        List<Book> result = bookService.findAvailableBooksByAuthor("Unknown");

        assertTrue(result.isEmpty());
    }
}
