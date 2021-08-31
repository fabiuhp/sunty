package br.com.sunty.repository.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;

public class CourseBuilder {
    private Course course;

    public CourseBuilder(String name, String urlCode, int timeToFinishInHours, Instructor instructor, SubCategory subCategory) {
        course = new Course(name, urlCode, timeToFinishInHours, instructor, subCategory);
    }

    public CourseBuilder publicVisibility() {
        course.publicVisibility();
        return this;
    }

    public Course build() {
        return course;
    }
}
