package nl.ilovecoding.testcontainers.repositories;

import nl.ilovecoding.testcontainers.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,String> {}
