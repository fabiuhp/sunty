package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;
import lombok.Value;

@Value
public class AdminSubCategoryDto {

    String name;
    String urlCode;
    Boolean active;
    Integer orderToShow;

    public AdminSubCategoryDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.active = subCategory.isActive();
        this.orderToShow = subCategory.getOrderToShow();
    }
}
