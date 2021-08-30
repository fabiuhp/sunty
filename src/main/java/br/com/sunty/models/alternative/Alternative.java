package br.com.sunty.models.alternative;

import br.com.sunty.models.activity.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

@Entity
@Table(name = "alternative")
@NoArgsConstructor
@Data
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String explanation;
    private Integer orderToShow;
    private boolean isCorrect;
    private String justification;
    @ManyToOne
    private Question question;

    public Alternative(String explanation, boolean isCorrect, Question question) {
        notBlank(explanation);
        notNull(question);

        this.explanation = explanation;
        this.isCorrect = isCorrect;
        this.question = question;
    }
}
