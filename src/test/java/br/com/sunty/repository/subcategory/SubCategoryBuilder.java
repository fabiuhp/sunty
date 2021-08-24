package br.com.sunty.repository.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;

public class SubCategoryBuilder {
    private SubCategory subCategory;

    public SubCategoryBuilder(String nome, String urlcode, Category category) {
        subCategory = new SubCategory(nome, urlcode, category);
    }

    public SubCategoryBuilder activate() {
        subCategory.activate();
        return this;
    }

    public SubCategory build() {
        return subCategory;
    }
}
