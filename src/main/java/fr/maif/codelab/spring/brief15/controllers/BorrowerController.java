package fr.maif.codelab.spring.brief15.controllers;

import fr.maif.codelab.spring.brief15.models.Book;
import fr.maif.codelab.spring.brief15.models.Borrower;
import fr.maif.codelab.spring.brief15.repositories.BookRepository;
import fr.maif.codelab.spring.brief15.repositories.BorrowerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class BorrowerController {
    private final BorrowerRepository borrowerRepository;
    private final BookRepository bookRepository;

    public BorrowerController(BorrowerRepository borrowerRepository, BookRepository bookRepository) {
        this.borrowerRepository = borrowerRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Borrower> addUser(@RequestBody Borrower borrower) {
        Borrower newBorrower = borrowerRepository.save(borrower);
        return ResponseEntity.ok(newBorrower);
    }

    // ne fonctionne pas
    @PostMapping(value = "/addbook", produces = "application/json")
    public ResponseEntity<Borrower> addBookToBorrower(@RequestBody Borrower borrower, @RequestBody Book book) {
        Book newBook = bookRepository.findById(book.getId()).orElse(null);
        List<Book> listBook = List.of();
        listBook.add(newBook);
        borrower.setBooks(listBook);
        return ResponseEntity.ok(borrowerRepository.save(borrower));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Borrower>> findAll() {
        return ResponseEntity.ok(borrowerRepository.findAll());
    }
}

/*
Borrower borrower = borrowerRepository.findById(bookRequest.getBorrowerId())
                .orElseThrow(() -> new RuntimeException("Borrower not found"));
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setGenres(bookRequest.getGenres());
        book.setEmprunt(bookRequest.getEmprunt());
        book.setBorrower(borrower);
        Book newBook = bookRepository.save(book);
        return ResponseEntity.ok(newBook);*/