package br.com.sunty.controller.dashboardadmin;

import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardAdminController {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    public DashboardAdminController(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/admin")
    public String redirectToDashboard(){
        return "login/";
    }
}
