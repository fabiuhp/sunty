package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import static br.com.sunty.models.validations.Validation.*;

public class Explanation extends Activity {

    private String text;

    public Explanation(String name, String urlCode, Section section, String text) {
        super(name, urlCode, section);
        nonEmptyFieldValidation(text, "Text");

        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "text='" + text + '\'' +
                '}';
    }
}
