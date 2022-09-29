package nl.ilovecoding.testcontainers.it;


import nl.ilovecoding.testcontainers.domain.Country;
import nl.ilovecoding.testcontainers.repositories.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("ittest")
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)

public class CrudActionsOnCountryTableTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("jdbc insert test")
    void simpleJdbcInsertTest(){

        String sql = "insert into country (iso,country_name,capital) values('BE','Belgium','Brussels')";
        jdbcTemplate.execute(sql);

        String countrys = "select * from country";
        RowMapper<Country> countryMapper = (rs, rowNum) -> {
            Country country = new Country();
            country.setIso(rs.getString("iso"));
            country.setCountryName(rs.getString("country_name"));
            country.setCapital(rs.getString("capital"));
            return country;
        };

        List<Country> query = jdbcTemplate.query(countrys, countryMapper);
        assertThat(query.size()).isEqualTo(1);
    }
    @Test

    void shouldAddCountry() {

        Country country = new Country();
        country.setIso("NL");
        country.setCountryName("The Netherlands");
        country.setCapital("Amsterdam");
        Country savedCountry = countryRepository.save(country);

        assertAll(
                () -> assertEquals("NL", savedCountry.getIso()),
                () -> assertEquals("The Netherlands", savedCountry.getCountryName()),
                () -> assertEquals("Amsterdam", savedCountry.getCapital())
        );

        Optional<Country> nl = countryRepository.findById("NL");
        assertTrue(nl.isPresent());

    }
}
