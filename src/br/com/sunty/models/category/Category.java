package br.com.sunty.models.category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.sunty.models.validations.Validation.*;

public class Category {

    private Long id;
    private String name;
    private String urlCode;
    private String shortDescription;
    private String guideText;
    private boolean isActive;
    private Integer order;
    private String pathImg;
    private String hexHtmlColor;
    private List<SubCategory> subCategoryList = new ArrayList<>();

    public Category(String name, String urlCode) {
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        nonEmptyFieldValidation(name, "Nome");

        this.name = name;
        this.urlCode = urlCode;
    }

    public Category(String name, String urlCode, String shortDescription, boolean isActive, Integer order, String pathImg, String hexHtmlColor) {
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        nonEmptyFieldValidation(name, "Nome");

        this.name = name;
        this.urlCode = urlCode;
        this.shortDescription = shortDescription;
        this.isActive = isActive;
        this.order = order;
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
                ", order=" + order +
                ", pathImg='" + pathImg + '\'' +
                ", hexHtmlColor='" + hexHtmlColor + '\'' +
                '}';
    }

    public void addSubCategory(SubCategory subCategory) {
        this.subCategoryList.add(subCategory);
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList.stream()
                .filter(SubCategory::getActive)
                .collect(Collectors.toList());
    }

    public int getCoursesQuantity() {
        return subCategoryList.stream().mapToInt(SubCategory::numberOfCourses).sum();
    }

    public int getTotalTimeToFinishAnHours() {
        return subCategoryList.stream().mapToInt(SubCategory::totalTimeToFinishInHours).sum();
    }
}
