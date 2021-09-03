package br.com.sunty.models.section;

import br.com.sunty.models.course.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.apache.commons.lang3.Validate.matchesPattern;
import static org.apache.commons.lang3.Validate.notBlank;

@Entity
@Table(name = "section")
@NoArgsConstructor
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;
    private Integer orderToShow;
    private boolean isExam;
    private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Section(String name, String urlCode) {
        notBlank(name);
        notBlank(urlCode);
        matchesPattern(urlCode, "[-a-z]+");

        this.name = name;
        this.urlCode = urlCode;
    }
}
