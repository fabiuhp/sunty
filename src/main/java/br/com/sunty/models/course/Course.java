package br.com.sunty.models.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.instructor.Instructor;
import org.springframework.util.Assert;

import javax.persistence.*;

import static org.apache.commons.lang3.Validate.exclusiveBetween;
import static org.apache.commons.lang3.Validate.matchesPattern;

@Entity
@Table(name = "course")
public class Course {
    public static final int MINIMUM_TIME_TO_FINISH = 1;
    public static final int MAXIMUM_TIME_TO_FINISH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;
    private int timeToFinishInHours;

    @Enumerated(EnumType.STRING)
    private CourseVisibility visibility = CourseVisibility.PRIVADA;
    private String targetAudience;

    @ManyToOne
    private Instructor instructor;

    @Column(columnDefinition = "TEXT")
    private String syllabus;

    @Column(columnDefinition = "TEXT")
    private String developedSkills;

    @ManyToOne
    private SubCategory subCategory;

    public Course() {}

    public Course(String name, String urlCode, int timeToFinishInHours, Instructor instructor, SubCategory subCategory) {
        Assert.hasText(name, "{course.name.not.null}");
        Assert.hasText(urlCode, "{course.url.not.null}");
        matchesPattern(urlCode, "[-a-z]+");
        exclusiveBetween(MINIMUM_TIME_TO_FINISH, MAXIMUM_TIME_TO_FINISH, timeToFinishInHours);
        Assert.notNull(instructor, "{course.instructor.not.null}");
        Assert.notNull(subCategory, "{course.category.not.null}");

        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
    }

    public Course(String name, String urlCode, int timeToFinishInHours, CourseVisibility visibility, String targetAudience, Instructor instructor, String syllabus, String developedSkills, SubCategory subCategory) {
        this(name, urlCode, timeToFinishInHours, instructor, subCategory);
        this.visibility = visibility;
        this.targetAudience = targetAudience;
        this.syllabus = syllabus;
        this.developedSkills = developedSkills;
    }

    public Course(Long id, String name, String urlCode, int timeToFinishInHours, CourseVisibility visibility, String targetAudience, Instructor instructor, String syllabus, String developedSkills, SubCategory subCategory) {
        this(name, urlCode, timeToFinishInHours, visibility, targetAudience, instructor, syllabus, developedSkills, subCategory);
        this.id = id;
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

    public Integer getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public void setTimeToFinishInHours(Integer timeToFinishInHours) {
        this.timeToFinishInHours = timeToFinishInHours;
    }

    public CourseVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(CourseVisibility visibility) {
        this.visibility = visibility;
    }

    public void publicVisibility() {
        this.visibility = CourseVisibility.PUBLICA;
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

    public boolean isPublic() {
        return visibility == CourseVisibility.PUBLICA;
    }

    public String getSubCategoryUrlCode() {
        return this.subCategory.getUrlCode();
    }

    public String getCategoryUrlCode() {
        return this.subCategory.getCategory().getUrlCode();
    }

    public Long getInstructorId() {
        return this.getInstructor().getId();
    }

    public Long getSubCategoryId() {
        return this.subCategory.getId();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlCode='" + urlCode + '\'' +
                ", timeToFinishInHours=" + timeToFinishInHours +
                ", visibility=" + visibility +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructor=" + instructor +
                ", syllabus='" + syllabus + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", category=" + subCategory +
                '}';
    }
}
