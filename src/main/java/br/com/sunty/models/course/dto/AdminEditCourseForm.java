package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AdminEditCourseForm {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final int timeToFinishInHours;
    private final CourseVisibility visibility;
    private final String targetAudience;
    private final Long instructorId;
    private final String syllabus;
    private final String developedSkills;
    private final Long subCategoryId;

    public AdminEditCourseForm(Long id, String name, String urlCode, int timeToFinishInHours, CourseVisibility visibility, String targetAudience, Long instructorId, String syllabus, String developedSkills, Long subCategoryId) {
        this.id = id;
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

    public static Course toModel(CourseRepository courseRepository, InstructorRepository instructorRepository, SubCategoryRepository subCategoryRepository, AdminEditCourseForm adminEditCourseForm) {
        Instructor instructor = instructorRepository.findById(adminEditCourseForm.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        SubCategory subCategory = subCategoryRepository.findById(adminEditCourseForm.getSubCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Course course = courseRepository.findById(adminEditCourseForm.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        course.setId(adminEditCourseForm.getId());
        course.setName(adminEditCourseForm.getName());
        course.setUrlCode(adminEditCourseForm.getUrlCode());
        course.setTimeToFinishInHours(adminEditCourseForm.getTimeToFinishInHours());
        course.setVisibility(adminEditCourseForm.getVisibility());
        course.setTargetAudience(adminEditCourseForm.getTargetAudience());
        course.setInstructor(instructor);
        course.setSyllabus(adminEditCourseForm.getSyllabus());
        course.setDevelopedSkills(adminEditCourseForm.getDevelopedSkills());
        course.setSubCategory(subCategory);

        return course;
    }

    public Long getId() {
        return id;
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
