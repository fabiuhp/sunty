package br.com.sunty.models.category;

import br.com.sunty.models.course.Course;
import lombok.Data;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.Validate.matchesPattern;

@Entity
@Table(name = "sub_category")
@Data
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
        category.addSubCategory(this);
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

    public void activate() {
        this.active = true;
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

    public List<Course> getPublicCourses() {
        return courseList.stream()
                .filter(Course::isPublic)
                .toList();
    }
}
