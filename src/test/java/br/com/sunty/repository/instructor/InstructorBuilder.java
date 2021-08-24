package br.com.sunty.repository.instructor;

import br.com.sunty.models.instructor.Instructor;

public class InstructorBuilder {
    private Instructor instructor;

    public InstructorBuilder(String nome) {
        instructor = new Instructor(nome);
    }

    public Instructor build() {
        return instructor;
    }
}
