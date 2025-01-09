package fr.maif.codelab.spring.brief15.repositories;

import fr.maif.codelab.spring.brief15.models.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
}
