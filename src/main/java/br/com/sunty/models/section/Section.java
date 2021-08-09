package br.com.sunty.models.section;

import br.com.sunty.models.course.Course;

import javax.persistence.*;

import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;
    private Integer orderToShow;
    private boolean isExam;
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Section(){
    }

    public Section(String name, String urlCode) {
        notBlank(name);
        notBlank(urlCode);
        matchesPattern(urlCode, "[-a-z]+");

        this.name = name;
        this.urlCode = urlCode;
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

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public void setOrderToShow(Integer order) {
        this.orderToShow = order;
    }

    public boolean getTest() {
        return isExam;
    }

    public void setTest(boolean test) {
        isExam = test;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
