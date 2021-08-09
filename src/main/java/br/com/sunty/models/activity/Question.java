package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static org.apache.commons.lang3.Validate.notBlank;

@Entity
@Table(name = "question")
public class Question extends Activity {

    private String description;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    public Question(String name, String urlCode, Section section, String description, QuestionType questionType) {
        super(name, urlCode, section);

        notBlank(description);

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
