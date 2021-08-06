package br.com.sunty.models.category;

import br.com.sunty.models.course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;
    private String shortDescription;
    private String guideText;
    private boolean isActive;
    private Integer orderToShow;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy="subCategory")
    private List<Course> courseList = new ArrayList<>();

    public SubCategory(){}

    public SubCategory(String name, String urlCode, Category category) {
        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
    }

    public SubCategory(String name, String urlCode, String shortDescription, boolean isActive, Integer orderToShow, Category category) {
        this.name = name;
        this.urlCode = urlCode;
        this.shortDescription = shortDescription;
        this.isActive = isActive;
        this.orderToShow = orderToShow;
        this.category = category;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGuideText() {
        return guideText;
    }

    public void setGuideText(String guideText) {
        this.guideText = guideText;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public void setOrderToShow(Integer order) {
        this.orderToShow = order;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlCode='" + urlCode + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", guideText='" + guideText + '\'' +
                ", isActive=" + isActive +
                ", order=" + orderToShow +
                ", category=" + category +
                '}';
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }

    public int numberOfCourses() {
        return courseList.size();
    }

    public int totalTimeToFinishInHours() {
        return courseList.stream().mapToInt(Course::getTimeToFinishInHours).sum();
    }

    public int getActiveAsNumber() {
        return this.isActive ? 1 : 0;
    }

    public List<Course> getPublicCourses() {
        return courseList.stream()
                .filter(Course::isPublic)
                .collect(Collectors.toList());
    }
}
