package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.dto.subcategory.ApiSubCategoryDetailsDto;

import java.util.List;

public class ApiCategoryDetailsDto {

    private final String name;
    private final String pathImg;
    private final List<ApiSubCategoryDetailsDto> apiSubCategoryDetailsDtos;

    public ApiCategoryDetailsDto(Category category) {
        this.name = category.getName();
        this.pathImg = category.getPathImg();
        this.apiSubCategoryDetailsDtos = category.getActiveSubCategoryList().stream()
                .map(ApiSubCategoryDetailsDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public List<ApiSubCategoryDetailsDto> getApiSubCategoryDetailsDtos() {
        return apiSubCategoryDetailsDtos;
    }

    public String getPathImg() {
        return pathImg;
    }
}