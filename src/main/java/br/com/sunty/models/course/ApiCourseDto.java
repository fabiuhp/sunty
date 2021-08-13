package br.com.sunty.models.course;

public class ApiCourseDto {
    private String name;
    private String urlCode;
    private int timeToFinishInHours;
    private String developedSkills;

    public ApiCourseDto(Course course) {
        this.name = course.getName();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
        this.urlCode = course.getUrlCode();
        this.developedSkills = course.getDevelopedSkills();
    }

    public String getName() {
        return name;
    }

    public int getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }
}
