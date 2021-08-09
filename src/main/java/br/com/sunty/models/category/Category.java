package br.com.sunty.models.category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{category.name.not.null}")
    @Size(max = 255, message = "{category.name.size.max}")
    private String name;
    @NotBlank(message = "{category.url.not.null}")
    @Size(max = 255, message = "{category.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{category.url.regex}")
    private String urlCode;
    private String shortDescription;
    private String guideText;
    private boolean isActive = true;
    @Positive
    private Integer orderToShow;
    @Size(max = 255, message = "{category.pathImg.size.max}")
    private String pathImg;
    @Size(max = 7, message = "{category.hexHtmlColor.size.max}")
    @Pattern(regexp = "#(([0-9a-fA-F]{2}){3}|([0-9a-fA-F]){3})$", message = "{category.hexHtmlColor.regex}")
    private String hexHtmlColor;
    @OneToMany(mappedBy="category")
    private List<SubCategory> subCategoryList = new ArrayList<>();

    @Deprecated
    public Category() {
    }

    public Category(String name, String urlCode) {
        notBlank(urlCode);
        matchesPattern(urlCode, "[-a-z]+");
        notBlank(name);

        this.name = name;
        this.urlCode = urlCode;
    }

    public Category(String name, String urlCode, String shortDescription, boolean isActive, Integer orderToShow, String pathImg, String hexHtmlColor) {
        this(name, urlCode);
        this.shortDescription = shortDescription;
        this.isActive = isActive;
        this.orderToShow = orderToShow;
        this.pathImg = pathImg;
        this.hexHtmlColor = hexHtmlColor;
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

    public void activate() {
        isActive = true;
    }

    public void inactivate() {
        isActive = false;
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
                ", isActive=" + isActive +
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
        this.isActive = !isActive;
    }
}
