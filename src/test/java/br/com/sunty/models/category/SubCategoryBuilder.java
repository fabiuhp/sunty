package br.com.sunty.models.category;

public class SubCategoryBuilder {
    private final SubCategory subCategory;

    public SubCategoryBuilder(String name, String urlCode, Category category){
        this.subCategory = new SubCategory(name, urlCode, category);
    }

    public SubCategoryBuilder withOrderToShow(Integer orderToShow) {
        subCategory.setOrderToShow(orderToShow);
        return this;
    }

    public SubCategoryBuilder active() {
        subCategory.setActive(true);
        return this;
    }

    public SubCategoryBuilder inactive() {
        subCategory.setActive(false);
        return this;
    }

    public SubCategoryBuilder withDescription(String shortDescription) {
        subCategory.setShortDescription(shortDescription);
        return this;
    }

    public SubCategory build() {
        return this.subCategory;
    }
}
