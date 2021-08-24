package br.com.sunty.repository.category;

import br.com.sunty.models.category.Category;

public class CategoryBuilder {
    private Category category;

    public CategoryBuilder(String nome, String urlcode) {
        category = new Category(nome, urlcode);
    }

    public CategoryBuilder inactive() {
        category.inactivate();
        return this;
    }

    public Category build() {
        return category;
    }
}
