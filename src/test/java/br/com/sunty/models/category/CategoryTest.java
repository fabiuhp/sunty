package br.com.sunty.models.category;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void shouldValidateCreatedCategory() {
        Category category = new Category("React", "react");

        assertEquals("React", category.getName());
        assertEquals("react", category.getUrlCode());
    }

    @Test
    public void shouldInvalidateNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Category(null, "abc"));
    }

    @Test
    public void shouldInvalidateNullUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new Category("abc", null));
    }

    @Test
    public void shouldInvalidateBlankUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new Category("abc", ""));
    }

    @Test
    public void shouldValidateBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Category("", "abc"));
    }

    @Test
    public void shouldInvalidateSpacedUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new Category("abc", " "));
    }

    @Test
    public void shouldInvalidateSpacedName() {
        assertThrows(IllegalArgumentException.class, () -> new Category(" ", "abc"));
    }

    @Test
    public void shouldInvalidateInvalidCharacterUrlCode() {
        assertThrows(IllegalArgumentException.class, () -> new Category("abc", "abc/abc"));
    }

    @Test
    public void shouldCreateFullCategory() {
        Category category = new Category("abc", "abc-abc", "abc description", true, 1, "abc/path", "#abc123");

        assertEquals("abc", category.getName());
        assertEquals("abc-abc", category.getUrlCode());
        assertEquals("abc description", category.getShortDescription());
        assertTrue(category.getActive());
        assertEquals(1, category.getOrder());
        assertEquals("abc/path", category.getPathImg());
        assertEquals("#abc123", category.getHexHtmlColor());
    }
}