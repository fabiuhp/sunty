package br.com.sunty.models.activity;

import br.com.sunty.models.activity.utils.Activity;
import br.com.sunty.models.activity.utils.QuestionType;
import br.com.sunty.models.section.Section;

public class Question extends Activity {

    private String description;
    private QuestionType questionType;

    public Question(Long id, String name, String urlCode, Section section, String description, QuestionType questionType) {
        super.setId(id);
        super.setName(name);
        super.setUrlCode(urlCode);
        super.setSection(section);
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
