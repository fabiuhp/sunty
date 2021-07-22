package br.com.sunty.models.category;

public class CategoryBuilder {
    private final Category category;

    public CategoryBuilder(String name, String urlCode){
        this.category = new Category(name, urlCode);
    }

    public CategoryBuilder withOrder(Integer orderToShow) {
        category.setOrderToShow(orderToShow);
        return this;
    }

    public CategoryBuilder activeCategory(Boolean active) {
        category.setActive(active);
        return this;
    }


    public Category build() {
        return this.category;
    }

}
