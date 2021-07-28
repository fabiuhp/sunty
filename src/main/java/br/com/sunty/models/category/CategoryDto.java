package br.com.sunty.models.category;

public class CategoryDto {
    private final String name;
    private final String urlCode;
    private final String shortDescription;
    private final String guideText;
    private final boolean isActive;
    private final Integer orderToShow;
    private final String pathImg;
    private final String hexHtmlColor;


    public CategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.shortDescription = category.getShortDescription();
        this.guideText = category.getGuideText();
        this.isActive = category.getActive();
        this.orderToShow = category.getOrderToShow();
        this.pathImg = category.getPathImg();
        this.hexHtmlColor = category.getHexHtmlColor();
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getGuideText() {
        return guideText;
    }

    public boolean isActive() {
        return isActive;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public String getPathImg() {
        return pathImg;
    }

    public String getHexHtmlColor() {
        return hexHtmlColor;
    }
}
