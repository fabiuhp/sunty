package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.*;

public class AdminNewCourseForm {

    @NotBlank(message = "{course.name.not.null}")
    @Size(max = 255, message = "{course.name.size.max}")
    private final String name;
    @NotBlank(message = "{course.url.not.null}")
    @Size(max = 255, message = "{course.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{course.url.regex}")
    private final String urlCode;
    @Min(value = 1)
    @Max(value = 20)
    private final int timeToFinishInHours;
    private final CourseVisibility visibility;
    private final String targetAudience;
    private final Long instructorId;
    private final String syllabus;
    private final String developedSkills;
    private final Long subCategoryId;

    public AdminNewCourseForm(String name, String urlCode, int timeToFinishInHours, CourseVisibility visibility, String targetAudience, Long instructorId, String syllabus, String developedSkills, Long subCategoryId) {
        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.visibility = visibility;
        this.targetAudience = targetAudience;
        this.instructorId = instructorId;
        this.syllabus = syllabus;
        this.developedSkills = developedSkills;
        this.subCategoryId = subCategoryId;
    }

    public Course toModel(InstructorRepository instructorRepository, SubCategoryRepository subCategoryRepository, AdminNewCourseForm adminNewCourseForm) {
        Instructor instructor = instructorRepository.findById(adminNewCourseForm.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        SubCategory subCategory = subCategoryRepository.findById(adminNewCourseForm.getSubCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new Course(
                adminNewCourseForm.getName(),
                adminNewCourseForm.getUrlCode(),
                adminNewCourseForm.getTimeToFinishInHours(),
                adminNewCourseForm.getVisibility(),
                adminNewCourseForm.getTargetAudience(),
                instructor,
                adminNewCourseForm.getSyllabus(),
                adminNewCourseForm.getDevelopedSkills(),
                subCategory
        );
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public int getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public CourseVisibility getVisibility() {
        return visibility;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }
}
