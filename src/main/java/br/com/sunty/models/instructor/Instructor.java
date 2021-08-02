package br.com.sunty.models.instructor;

import javax.persistence.*;

import static br.com.sunty.models.validations.Validation.nonEmptyFieldValidation;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Instructor() {
    }

    public Instructor(String name) {
        nonEmptyFieldValidation(name, "Nome");

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
