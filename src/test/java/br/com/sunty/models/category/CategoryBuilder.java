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

    public CategoryBuilder activeCategory() {
        category.activate();
        return this;
    }

    public CategoryBuilder inactiveCategory() {
        category.inactivate();
        return this;
    }


    public Category build() {
        return this.category;
    }

}
