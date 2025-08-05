package org.example.exercise;

import java.util.List;

public interface BookRepository {
  Book findById(String id);

  void save(Book book);

  List<Book> findAllAvailableBooks();
}
