package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import static br.com.sunty.models.validations.Validation.*;

public class Explanation extends Activity {

    private String text;

    public Explanation(Long id, String name, String urlCode, Section section, String text) {
        super(id, name, urlCode, section);

        nonEmptyFieldValidation(name, "Nome não pode ser nulo.");
        urlValidation(urlCode, "Url só deve conter letras minusculas e traços.");
        classNonNullValidation(section, "Seção não pode ser nula.");

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
