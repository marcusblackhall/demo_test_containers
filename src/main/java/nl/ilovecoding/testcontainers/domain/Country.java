package nl.ilovecoding.testcontainers.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    private String iso;

    @Column(name ="country_name")
    private String countryName;

    @Column(name = "capital")
    private String capital;
}


