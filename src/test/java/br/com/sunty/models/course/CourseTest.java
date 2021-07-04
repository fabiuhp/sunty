package br.com.sunty.models.course;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.instructor.Instructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {
    Category category = new Category("React", "react");
    SubCategory subCategory = new SubCategory("frontend", "front-react", category);
    Instructor instructor = new Instructor("Fabio");

    @Test
    public void shouldInvalidateNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Course(null, "SPA", 20, instructor, subCategory));
    }

    @Test
    public void shouldInvalidateNullUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Single Page Application", null, 20, instructor, subCategory));
    }

    @Test
    public void shouldInvalidateNumberAboveLimitForTimeForFinishInHours() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Single Page Application", "SPA", 21, instructor, subCategory));
    }

    @Test
    public void shouldInvalidateNumberBelowLimitForTimeForFinishInHours() {
        assertThrows(IllegalArgumentException.class, () -> new Course("Single Page Application", "SPA", 0, instructor, subCategory));
    }

    @Test
    public void shouldInvalidateNullInstructor() {
        Instructor instructorNull = null;
        assertThrows(IllegalArgumentException.class, () -> new Course("Single Page Application", "SPA", 0, instructorNull, subCategory));
    }

    @Test
    public void shouldInvalidateNullSubCategory() {
        SubCategory subCategoryNull = null;
        assertThrows(IllegalArgumentException.class, () -> new Course("Single Page Application", "SPA", 0, instructor, subCategoryNull));
    }
}