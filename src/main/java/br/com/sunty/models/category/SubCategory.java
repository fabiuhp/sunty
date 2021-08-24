package br.com.sunty.models.category;

import br.com.sunty.models.course.Course;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.Validate.matchesPattern;

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
    private boolean active;
    private Integer orderToShow;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy="subCategory")
    private List<Course> courseList = new ArrayList<>();

    public SubCategory(){}

    public SubCategory(String name, String urlCode, Category category) {
        Assert.hasText(urlCode, "{subcategory.url.not.null}");
        matchesPattern(urlCode, "[-a-z]+");
        Assert.hasText(name, "{subcategory.name.not.null}");
        Assert.notNull(category, "{subcategory.category.not.null}");

        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
    }

    public SubCategory(String name, String urlCode, String shortDescription, boolean active, Integer orderToShow, Category category) {
        this(name, urlCode, category);
        this.shortDescription = shortDescription;
        this.active = active;
        this.orderToShow = orderToShow;
    }

    public SubCategory(String name, String urlCode, String shortDescription, Boolean active, Integer orderToShow, String guideText, Category category) {
        this(name, urlCode, category);
        this.shortDescription = shortDescription;
        this.active = active;
        this.orderToShow = orderToShow;
        this.guideText = guideText;
    }

    public SubCategory(Long id, String name, String urlCode, String shortDescription, Boolean active, Integer orderToShow, String guideText, Category category) {
        this(name, urlCode, category);
        this.id = id;
        this.shortDescription = shortDescription;
        this.active = active;
        this.orderToShow = orderToShow;
        this.guideText = guideText;
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
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void activate() {
        this.active = true;
    }

    public void inactivate() {
        this.active = false;
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
                ", isActive=" + active +
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

    public List<Course> getCourseList() {
        return courseList;
    }

    public Long getCategoryId () {
        return this.category.getId();
    }

    public String getCategoryName() {
        return this.category.getName();
    }

    public int totalTimeToFinishInHours() {
        return courseList.stream().mapToInt(Course::getTimeToFinishInHours).sum();
    }

    public List<Course> getPublicCourses() {
        return courseList.stream()
                .filter(Course::isPublic)
                .toList();
    }
}
