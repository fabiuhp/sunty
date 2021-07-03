package br.com.sunty.models.alternative;

import br.com.sunty.models.activity.Question;

import static br.com.sunty.models.validations.Validation.*;

public class Alternative {

    private Long id;
    private String explanation;
    private Integer order;
    private boolean isCorrect;
    private String justification;
    private Question question;

    public Alternative(String explanation, boolean isCorrect, Question question) {
        nonEmptyFieldValidation(explanation, "Explicação");
        classNonNullValidation(question, "Questão");

        this.explanation = explanation;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
                ", explanation='" + explanation + '\'' +
                ", order=" + order +
                ", isCorrect=" + isCorrect +
                ", justification='" + justification + '\'' +
                ", question=" + question +
                '}';
    }
}
