package ru.gb.homework12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework12.model.Book;


public interface BookStoreRepository extends JpaRepository<Book, Long> {

}
