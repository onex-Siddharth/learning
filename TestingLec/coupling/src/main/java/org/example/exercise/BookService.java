package org.example.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book borrowBook(String bookId) {
    Book book = bookRepository.findById(bookId);
    if (book == null) {
      throw new IllegalArgumentException("Book not found");
    }
    if (!book.isAvailable()) {
      throw new IllegalStateException("Book is already borrowed");
    }
    book.setAvailable(false);
    bookRepository.save(book);
    return book;
  }

  public Book returnBook(String bookId) {
    Book book = bookRepository.findById(bookId);
    if (book == null) {
      throw new IllegalArgumentException("Book not found");
    }
    if (book.isAvailable()) {
      throw new IllegalStateException("Book was not borrowed");
    }
    book.setAvailable(true);
    bookRepository.save(book);
    return book;
  }

  public List<Book> findAvailableBooksByAuthor(String author) {
    return bookRepository.findAllAvailableBooks().stream()
        .filter(book -> book.getAuthor().equals(author))
        .collect(Collectors.toList());
  }
}
