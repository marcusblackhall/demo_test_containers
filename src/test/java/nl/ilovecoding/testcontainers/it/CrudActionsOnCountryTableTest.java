package nl.ilovecoding.testcontainers.it;


import nl.ilovecoding.testcontainers.domain.Country;
import nl.ilovecoding.testcontainers.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("ittest")
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
public class CrudActionsOnCountryTableTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void shouldAddCountry() {

        Country country = new Country();
        country.setIso("NL");
        country.setName("The Netherlands");
        country.setCapital("Amsterdam");
        Country savedCountry = countryRepository.save(country);

        assertAll(
                () -> assertEquals("NL", savedCountry.getIso()),
                () -> assertEquals("The Netherlands", savedCountry.getName()),
                () -> assertEquals("Amsterdam", savedCountry.getCapital())
        );

    }
}
