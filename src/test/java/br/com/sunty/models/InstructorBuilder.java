package br.com.sunty.models;

import br.com.sunty.models.instructor.Instructor;

public class InstructorBuilder {

    private final Instructor instructor;

    public InstructorBuilder(String name){
        this.instructor = new Instructor(name);
    }

    public Instructor build(){
        return instructor;
    }
}
