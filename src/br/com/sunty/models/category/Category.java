package br.com.sunty.models.category;

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

    public Category(String name, String urlCode) {
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        nonEmptyFieldValidation(name, "Nome");

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
}
