package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static org.apache.commons.lang3.Validate.notBlank;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
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
}
