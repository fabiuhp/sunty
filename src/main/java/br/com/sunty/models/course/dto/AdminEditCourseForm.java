package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEditCourseForm {

    private Long id;

    @NotBlank(message = "{course.name.not.null}")
    @Size(max = 255, message = "{course.name.size.max}")
    private String name;

    @NotBlank(message = "{subcategory.url.not.null}")
    @Size(max = 255, message = "{subcategory.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{subcategory.url.regex}")
    private String urlCode;
    private int timeToFinishInHours;
    private CourseVisibility visibility;
    private String targetAudience;
    private Long instructorId;
    private String syllabus;
    private String developedSkills;
    private Long subCategoryId;

    public AdminEditCourseForm(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.urlCode = course.getUrlCode();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
        this.visibility = course.getVisibility();
        this.targetAudience = course.getTargetAudience();
        this.instructorId = course.getInstructorId();
        this.syllabus = course.getSyllabus();
        this.developedSkills = course.getDevelopedSkills();
        this.subCategoryId = course.getSubCategoryId();
    }

    public Course toModel(Instructor instructor,SubCategory subCategory) {
        return new Course(
                this.id,
                this.name,
                this.urlCode,
                this.timeToFinishInHours,
                this.visibility,
                this.targetAudience,
                instructor,
                this.syllabus,
                this.developedSkills,
                subCategory
        );
    }
}
