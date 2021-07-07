package br.com.sunty.models.instructor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    @Test
    public void shouldCreateInstructor() {
        Instructor instructor = new Instructor("Fabio");

        assertEquals("Fabio", instructor.getName());
    }

    @Test
    public void shouldNotCreateInstructorNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Instructor(null));
    }

    @Test
    public void shouldNotCreateInstructorBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Instructor(""));
    }

    @Test
    public void shouldNotCreateInstructorSpacedName() {
        assertThrows(IllegalArgumentException.class, () -> new Instructor(" "));
    }
}