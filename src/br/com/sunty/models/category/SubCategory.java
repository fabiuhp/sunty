package br.com.sunty.models.category;

import static br.com.sunty.models.validations.Validation.*;

public class SubCategory {

    private Long id;
    private String name;
    private String urlCode;
    private String shortDescription;
    private String guideText;
    private Boolean isActive;
    private Integer order;
    private Category category;

    public SubCategory(String name, String urlCode, Category category) {
        nonEmptyFieldValidation(name, "Nome");
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        classNonNullValidation(category, "Categoria");

        this.name = name;
        this.urlCode = urlCode;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
                ", order=" + order +
                ", category=" + category +
                '}';
    }
}
