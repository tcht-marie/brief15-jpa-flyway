package fr.maif.codelab.spring.brief15.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_genres",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @OneToOne
    private Emprunt emprunt;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public Borrower getBorrower() {
        return borrower;
    }
}
