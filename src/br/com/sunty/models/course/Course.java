package br.com.sunty.models.course;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.instructor.Instructor;

import static br.com.sunty.models.validations.Validation.*;

public class Course {

    private Long id;
    private String name;
    private String urlCode;
    private int timeToFinish;
    private CourseVisibility visibility = CourseVisibility.PRIVATE;
    private String targetAudience;
    private Instructor instructor;
    private String syllabus;
    private String developedSkills;
    private Category category;

    public Course(Long id, String name, String urlCode, int timeToFinish, Instructor instructor, Category category) {
        nonEmptyFieldValidation(name, "Nome não pode ser nulo.");
        nonEmptyFieldValidation(urlCode, "Url do curso não pode ser nula ou vazia.");
        urlValidation(urlCode, "Url só deve conter letras minusculas e traços.");
        intervalValidation(1, 20, timeToFinish, "O tempo do curso deve ser entre 1 e 20 horas.");
        classNonNullValidation(instructor, "Instrutor não pode ser nulo.");
        classNonNullValidation(category, "Categoria não pode ser nula.");

        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinish = timeToFinish;
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

    public Integer getTimeToFinish() {
        return timeToFinish;
    }

    public void setTimeToFinish(Integer timeToFinish) {
        this.timeToFinish = timeToFinish;
    }

    public CourseVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(CourseVisibility visibility) {
        this.visibility = visibility;
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
                ", timeToFinish=" + timeToFinish +
                ", visibility=" + visibility +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructor=" + instructor +
                ", syllabus='" + syllabus + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", category=" + category +
                '}';
    }
}
