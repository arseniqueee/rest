package rest.countries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.countries.model.Countries;

public interface CountriesDaoTest extends JpaRepository<Countries, Long> {
}
