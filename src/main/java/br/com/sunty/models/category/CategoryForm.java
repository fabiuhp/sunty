package br.com.sunty.models.category;

public class CategoryForm {

    private String name;
    private String urlCode;

    public CategoryForm() {
    }

    public CategoryForm(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Category convert(CategoryForm categoryForm) {
        return new Category(categoryForm.getName(), categoryForm.getUrlCode());
    }
}
