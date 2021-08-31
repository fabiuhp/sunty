package br.com.sunty.models.category;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.Validate.matchesPattern;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;
    private String shortDescription;
    private String guideText;
    private boolean active = true;
    private Integer orderToShow;
    private String pathImg;
    private String hexHtmlColor;
    @OneToMany(mappedBy="category")
    private List<SubCategory> subCategoryList = new ArrayList<>();

    @Deprecated
    public Category() {
    }

    public Category(String name, String urlCode) {
        Assert.hasText(urlCode, "{category.url.not.null}");
        matchesPattern(urlCode, "[-a-z]+");
        Assert.hasText(name, "{category.name.not.null}");

        this.name = name;
        this.urlCode = urlCode;
    }

    public Category(String name, String urlCode, String shortDescription, boolean active, Integer orderToShow, String pathImg, String hexHtmlColor) {
        this(name, urlCode);
        this.shortDescription = shortDescription;
        this.active = active;
        this.orderToShow = orderToShow;
        this.pathImg = pathImg;
        this.hexHtmlColor = hexHtmlColor;
    }

    public Category(String name, String urlCode, String shortDescription, String guideText, boolean active, Integer orderToShow, String pathImg, String hexHtmlColor) {
        this(name, urlCode, shortDescription, active, orderToShow, pathImg, hexHtmlColor);
        this.guideText = guideText;
    }

    public Category(Long id, String name, String urlCode, String shortDescription, String guideText, boolean active, Integer orderToShow, String pathImg, String hexHtmlColor) {
        this(name, urlCode, shortDescription, guideText, active, orderToShow, pathImg, hexHtmlColor);
        this.id = id;
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
        active = true;
    }

    public void inactivate() {
        active = false;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public void setOrderToShow(Integer order) {
        this.orderToShow = order;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public String getHexHtmlColor() {
        return hexHtmlColor;
    }

    public void setHexHtmlColor(String hexHtmlColor) {
        this.hexHtmlColor = hexHtmlColor;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlCode='" + urlCode + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", guideText='" + guideText + '\'' +
                ", isActive=" + active +
                ", order=" + orderToShow +
                ", pathImg='" + pathImg + '\'' +
                ", hexHtmlColor='" + hexHtmlColor + '\'' +
                '}';
    }

    public void addSubCategory(SubCategory subCategory) {
        this.subCategoryList.add(subCategory);
    }

    public List<SubCategory> getActiveSubCategoryList() {
        return subCategoryList.stream()
                .filter(SubCategory::getActive)
                .collect(Collectors.toList());
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public int getCoursesQuantity() {
        return subCategoryList.stream().mapToInt(SubCategory::numberOfCourses).sum();
    }

    public int getTotalTimeToFinishInHours() {
        return subCategoryList.stream().mapToInt(SubCategory::totalTimeToFinishInHours).sum();
    }

    public void toggle() {
        this.active = !active;
    }
}
