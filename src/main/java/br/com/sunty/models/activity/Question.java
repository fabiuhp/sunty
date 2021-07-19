package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import javax.persistence.Entity;
import javax.persistence.Table;

import static br.com.sunty.models.validations.Validation.*;

@Entity
@Table(name = "question")
public class Question extends Activity {

    private String description;
    private QuestionType questionType;

    public Question(String name, String urlCode, Section section, String description, QuestionType questionType) {
        super(name, urlCode, section);

        nonEmptyFieldValidation(description, "Descrição");

        this.description = description;
        this.questionType = questionType;
    }

    public Question() {
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
