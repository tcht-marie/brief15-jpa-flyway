package fr.maif.codelab.spring.brief15.dto;

import fr.maif.codelab.spring.brief15.models.Emprunt;
import fr.maif.codelab.spring.brief15.models.Genre;

import java.util.List;

public class BookRequest {
    private String name;
    private String author;
    private List<Genre> genres;
    private Emprunt emprunt;
    private int borrowerId;

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

    public int getBorrowerId() {
        return borrowerId;
    }
}
