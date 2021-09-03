package br.com.sunty.models.category;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubCategoryTest {
    Category category = new Category("React", "react");

    @Test
    public void shouldValidateCreatedSubCategory() {
        SubCategory subCategory = new SubCategory("frontend", "front-react", category);

        assertEquals("React", category.getName());
        assertEquals("react", category.getUrlCode());
        assertEquals("frontend", subCategory.getName());
        assertEquals("front-react", subCategory.getUrlCode());
        assertEquals(category.getName(), subCategory.getCategory().getName());
        assertEquals(category.getUrlCode(), subCategory.getCategory().getUrlCode());
    }

    @Test
    public void shouldInvalidateNullName() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory(null, "front-end", category));
    }

    @Test
    public void shouldInvalidateNullUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("null", null, category));
    }

    @Test
    public void shouldInvalidateBlankUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("abc", "", category));
    }

    @Test
    public void shouldValidateBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("", "abc", category));
    }

    @Test
    public void shouldInvalidateSpacedUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("abc", " ", category));
    }

    @Test
    public void shouldInvalidateSpacedName() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory(" ", "abc", category));
    }

    @Test
    public void shouldInvalidateInvalidCharacterUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("abc", "abc/abc", category));
    }

    @Test
    public void shouldNotClassNull() {
        assertThrows(IllegalArgumentException.class, () -> new SubCategory("abc", "abc-abc", "abc description", true, 1, null));
    }

    @Test
    public void shouldCreateFullSubCategory() {
        SubCategory subCategory = new SubCategory("abc", "abc-abc", "abc description", true, 1, category);

        assertEquals("abc", subCategory.getName());
        assertEquals("abc-abc", subCategory.getUrlCode());
        assertEquals("abc description", subCategory.getShortDescription());
        assertTrue(subCategory.isActive());
        assertEquals(1, subCategory.getOrderToShow());
        assertEquals(category.getName(), subCategory.getCategory().getName());
        assertEquals(category.getUrlCode(), subCategory.getCategory().getUrlCode());
    }
}