package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;
import lombok.Value;

@Value
public class AdminCategoryDto {
    String name;
    String urlCode;
    Integer orderToShow;
    boolean active;

    public AdminCategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.orderToShow = category.getOrderToShow();
        this.active = category.isActive();
    }
}
