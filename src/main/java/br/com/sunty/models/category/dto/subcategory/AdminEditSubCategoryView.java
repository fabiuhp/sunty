package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;
import lombok.Value;

@Value
public class AdminEditSubCategoryView {

    Long id;
    String name;
    String urlCode;
    Boolean active;
    Integer orderToShow;
    String guideText;
    String shortDescription;
    Long categoryId;
    String categoryName;

    public AdminEditSubCategoryView(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.active = subCategory.getActive();
        this.orderToShow = subCategory.getOrderToShow();
        this.guideText = subCategory.getGuideText();
        this.shortDescription = subCategory.getShortDescription();
        this.categoryId = subCategory.getCategoryId();
        this.categoryName = subCategory.getCategoryName();
    }
}
