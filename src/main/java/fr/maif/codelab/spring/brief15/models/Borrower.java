package fr.maif.codelab.spring.brief15.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_id")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Borrower(){}
}
