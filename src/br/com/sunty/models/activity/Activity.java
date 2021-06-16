package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import static br.com.sunty.models.validations.Validation.*;

public abstract class Activity {

    private Long id;
    private String name;
    private String urlCode;
    private Boolean isActive;
    private Integer order;
    private Section section;

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
