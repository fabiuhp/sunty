package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import static br.com.sunty.models.validations.Validation.*;

public class Question extends Activity {

    private String description;
    private QuestionType questionType;

    public Question(Long id, String name, String urlCode, Section section, String description, QuestionType questionType) {
        super(id, name, urlCode, section);

        nonEmptyFieldValidation(name, "Nome não pode ser nulo.");
        nonEmptyFieldValidation(description, "Descrição não pode ser nula.");
        urlValidation(urlCode, "Url só deve conter letras minusculas e traços.");
        classNonNullValidation(section, "Seção não pode ser nula.");

        this.description = description;
        this.questionType = questionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "description='" + description + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}
