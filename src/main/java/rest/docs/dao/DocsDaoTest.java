package rest.docs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.docs.model.Docs;

public interface DocsDaoTest extends JpaRepository<Docs, Long> {
}
