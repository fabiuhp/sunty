package br.com.sunty.controller.dashboardadmin;

import br.com.sunty.models.course.CourseProjection;
import br.com.sunty.models.instructor.InstructorProjection;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class DashboardAdminController {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    @GetMapping("/admin")
    public String redirectToDashboard(){
        return "login/";
    }

    @GetMapping("/admin/dashboard")
    public String findAll(Model model) {
        List<InstructorProjection> instructorProjections = instructorRepository.instructorWithMoreCourses();
        List<CourseProjection> courseProjections = courseRepository.categoriesWithNumberOfCourses();
        model.addAttribute("instructorProjections", instructorProjections);
        model.addAttribute("courseProjections", courseProjections);
        return "dashboardadmin/dashboardAdminList";
    }
}
