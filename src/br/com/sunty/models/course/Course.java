package br.com.sunty.models.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.instructor.Instructor;

import static br.com.sunty.models.validations.Validation.*;

public class Course {

    private Long id;
    private String name;
    private String urlCode;
    private int timeToFinishAnHours;
    private CourseVisibility visibility = CourseVisibility.PRIVATE;
    private String targetAudience;
    private Instructor instructor;
    private String syllabus;
    private String developedSkills;
    private SubCategory subCategory;

    public Course(String name, String urlCode, int timeToFinishAnHours, Instructor instructor, SubCategory subCategory) {
        nonEmptyFieldValidation(name, "Nome");
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        intervalValidation(1, 20, timeToFinishAnHours, "O tempo do curso deve ser entre 1 e 20 horas.");
        classNonNullValidation(instructor, "Instrutor");
        classNonNullValidation(subCategory, "Categoria");

        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishAnHours = timeToFinishAnHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
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

    public Integer getTimeToFinishAnHours() {
        return timeToFinishAnHours;
    }

    public void setTimeToFinishAnHours(Integer timeToFinishAnHours) {
        this.timeToFinishAnHours = timeToFinishAnHours;
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

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlCode='" + urlCode + '\'' +
                ", timeToFinishAnHours=" + timeToFinishAnHours +
                ", visibility=" + visibility +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructor=" + instructor +
                ", syllabus='" + syllabus + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", category=" + subCategory +
                '}';
    }
}
