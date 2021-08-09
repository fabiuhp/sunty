package br.com.sunty.models.category;

import br.com.sunty.models.course.CourseDto;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SubCategoryEditDto {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final String guideText;

    public SubCategoryEditDto(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.guideText = subCategory.getGuideText();
    }

    public void toEntity(SubCategory subCategory) {
        subCategory.setName(this.name);
        subCategory.setUrlCode(this.urlCode);
        subCategory.setGuideText(this.guideText);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getGuideText() {
        return guideText;
    }
}
