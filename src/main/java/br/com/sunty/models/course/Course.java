package br.com.sunty.models.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.instructor.Instructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

import static org.apache.commons.lang3.Validate.exclusiveBetween;
import static org.apache.commons.lang3.Validate.matchesPattern;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
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
        subCategory.addCourse(this);
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

    public boolean isPublic() {
        return CourseVisibility.PUBLICA.equals(visibility);
    }

    public void visibilityPublic() {
        this.visibility = CourseVisibility.PUBLICA;
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
}
