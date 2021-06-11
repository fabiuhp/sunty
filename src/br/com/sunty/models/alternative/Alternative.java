package br.com.sunty.models.alternative;

import br.com.sunty.models.activity.Question;

import static br.com.sunty.models.validations.Validation.*;

public class Alternative {

    private Long id;
    private String explainText;
    private Integer order;
    private Boolean isCorrect;
    private String justificative;
    private Question question;

    public Alternative(Long id, String explainText, Boolean isCorrect, Question question) {
        emptyFieldValidation(explainText, "Explicação não pode ser nula.");
        classNonNullValidation(question, "Questão não pode ser nulo.");

        this.id = id;
        this.explainText = explainText;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExplainText() {
        return explainText;
    }

    public void setExplainText(String explainText) {
        this.explainText = explainText;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public String getJustificative() {
        return justificative;
    }

    public void setJustificative(String justificative) {
        this.justificative = justificative;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "id=" + id +
                ", explainText='" + explainText + '\'' +
                ", order=" + order +
                ", isCorrect=" + isCorrect +
                ", justificative='" + justificative + '\'' +
                ", question=" + question +
                '}';
    }
}
