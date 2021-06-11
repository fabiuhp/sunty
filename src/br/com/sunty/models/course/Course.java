package br.com.sunty.models.course;

import br.com.sunty.models.Category.Category;
import br.com.sunty.models.instructor.Instructor;

import static br.com.sunty.models.validations.Validation.*;

public class Course {

    private Long id;
    private String name;
    private String urlCode;
    private Integer timeForFinish;
    private CourseVisibility courseVisibility;
    private String targetAudience;
    private Instructor instructor;
    private String syllabus;
    private String developedSkills;
    private Category category;

    public Course(Long id, String name, String urlCode, Integer timeForFinish, Instructor instructor, Category category) {
        emptyFieldValidation(name, "Nome não pode ser nulo.");
        urlValidation(urlCode, "Url só deve conter letras minusculas e traços.");
        intervalValidation(1, 20, timeForFinish, "O tempo do curso deve ser entre 1 e 20 horas.");
        classNonNullValidation(instructor, "Instrutor não pode ser nulo.");
        classNonNullValidation(category, "Categoria não pode ser nula.");

        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.timeForFinish = timeForFinish;
        this.instructor = instructor;
        this.category = category;
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

    public Integer getTimeForFinish() {
        return timeForFinish;
    }

    public void setTimeForFinish(Integer timeForFinish) {
        this.timeForFinish = timeForFinish;
    }

    public CourseVisibility getCourseVisibility() {
        return courseVisibility;
    }

    public void setCourseVisibility(CourseVisibility courseVisibility) {
        this.courseVisibility = courseVisibility;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlCode='" + urlCode + '\'' +
                ", timeForFinish=" + timeForFinish +
                ", courseVisibility=" + courseVisibility +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructor=" + instructor +
                ", syllabus='" + syllabus + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", category=" + category +
                '}';
    }
}
