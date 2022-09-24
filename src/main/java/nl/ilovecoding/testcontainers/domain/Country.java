package nl.ilovecoding.testcontainers.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Country {

    @Id
    private String iso;

    private String name;

    private String capital;
}


