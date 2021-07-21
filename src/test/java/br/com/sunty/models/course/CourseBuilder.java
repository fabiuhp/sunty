package br.com.sunty.models.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.instructor.Instructor;

public class CourseBuilder {
    private final Course course;

    public CourseBuilder(String name, String urlCode, int timeToFinishInHours, Instructor instructor, SubCategory subCategory){
        this.course = new Course(name, urlCode, timeToFinishInHours, instructor, subCategory);
    }

    public CourseBuilder withVisibility(CourseVisibility visibility) {
        course.setVisibility(visibility);
        return this;
    }

    public Course build() {
        return this.course;
    }
}
