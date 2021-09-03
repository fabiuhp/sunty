package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;
import lombok.Value;

import javax.validation.constraints.*;

@Value
public class AdminNewCourseForm {

    @NotBlank(message = "{course.name.not.null}")
    @Size(max = 255, message = "{course.name.size.max}")
    String name;

    @NotBlank(message = "{course.url.not.null}")
    @Size(max = 255, message = "{course.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{course.url.regex}")
    String urlCode;

    @Min(value = 1)
    @Max(value = 20)
    int timeToFinishInHours;
    CourseVisibility visibility;
    String targetAudience;
    Long instructorId;
    String syllabus;
    String developedSkills;
    Long subCategoryId;

    public Course toModel(Instructor instructor, SubCategory subCategory) {
        return new Course(
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
