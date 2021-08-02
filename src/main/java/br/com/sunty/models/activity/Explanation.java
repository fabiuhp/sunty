package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import javax.persistence.Entity;
import javax.persistence.Table;

import static br.com.sunty.models.validations.Validation.nonEmptyFieldValidation;

@Entity
@Table(name = "explanation")
public class Explanation extends Activity {

    private String text;

    public Explanation() {
    }

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
