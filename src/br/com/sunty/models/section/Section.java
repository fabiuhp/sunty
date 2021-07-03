package br.com.sunty.models.section;

import br.com.sunty.models.course.Course;

import static br.com.sunty.models.validations.Validation.*;

public class Section {

    private Long id;
    private String name;
    private String urlCode;
    private Integer order;
    private boolean isExam;
    private boolean isActive;
    private Course course;

    public Section(String name, String urlCode, Course course) {
        nonEmptyFieldValidation(name, "Nome");
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        classNonNullValidation(course, "Curso");

        this.name = name;
        this.urlCode = urlCode;
        this.course = course;
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

    public String getUrlCode() {
        return urlCode;
    }

    public void setUrlCode(String urlCode) {
        this.urlCode = urlCode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean getTest() {
        return isExam;
    }

    public void setTest(boolean test) {
        isExam = test;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
