package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import javax.persistence.*;

import static br.com.sunty.models.validations.Validation.*;

@MappedSuperclass
public abstract class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;
    private boolean isActive;
    private Integer orderToShow;
    @ManyToOne
    private Section section;

    public Activity() {
    }

    public Activity(String name, String urlCode, Section section) {
        nonEmptyFieldValidation(urlCode, "Url");
        urlValidation(urlCode);
        nonEmptyFieldValidation(name, "Nome");
        classNonNullValidation(section, "Seção");

        this.name = name;
        this.urlCode = urlCode;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public void setUrlCode(String urlCode) {
        this.urlCode = urlCode;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public void setOrderToShow(Integer order) {
        this.orderToShow = order;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
