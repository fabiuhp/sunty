package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

import static org.apache.commons.lang3.Validate.notBlank;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "explanation")
@Data
@NoArgsConstructor
public class Explanation extends Activity {

    private String text;

    public Explanation(String name, String urlCode, Section section, String text) {
        super(name, urlCode, section);
        notBlank(text);

        this.text = text;
    }
}
