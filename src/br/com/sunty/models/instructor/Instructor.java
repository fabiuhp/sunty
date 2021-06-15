package br.com.sunty.models.instructor;

import static br.com.sunty.models.validations.Validation.*;

public class Instructor {

    private Long id;
    private String name;

    public Instructor(Long id, String name) {
        nonEmptyIdValidation(id);
        nonEmptyFieldValidation(name, "Nome");

        this.id = id;
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
