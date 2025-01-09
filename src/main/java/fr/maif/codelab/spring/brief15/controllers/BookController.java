package fr.maif.codelab.spring.brief15.controllers;

import fr.maif.codelab.spring.brief15.dto.BookRequest;
import fr.maif.codelab.spring.brief15.models.Book;
import fr.maif.codelab.spring.brief15.models.Borrower;
import fr.maif.codelab.spring.brief15.repositories.BookRepository;
import fr.maif.codelab.spring.brief15.repositories.BorrowerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookRepository.save(book);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
}
