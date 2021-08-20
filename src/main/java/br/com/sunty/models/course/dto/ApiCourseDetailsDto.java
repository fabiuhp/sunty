package br.com.sunty.models.course.dto;

import br.com.sunty.models.course.Course;

public class ApiCourseDetailsDto {

    private final String name;
    private final Integer timeToFinishInHours;

    public ApiCourseDetailsDto(Course course) {
        this.name = course.getName();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
    }

    public String getName() {
        return name;
    }

    public Integer getTimeToFinishInHours() {
        return timeToFinishInHours;
    }
}