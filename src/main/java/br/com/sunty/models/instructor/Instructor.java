package br.com.sunty.models.instructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.apache.commons.lang3.Validate.notBlank;

@Entity
@Table(name = "instructor")
@NoArgsConstructor
@Data
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Instructor(String name) {
        notBlank(name);

        this.name = name;
    }
}
