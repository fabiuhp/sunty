package br.com.sunty.models.section;

import br.com.sunty.models.course.Course;

public class Section {

    private Long id;
    private String name;
    private String urlCode;
    private Integer order;
    private Boolean isTest = true;
    private Boolean isActive = true;
    private Course course;

    public Section(Long id, String name, String urlCode, Course course) {
        this.id = id;
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

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
