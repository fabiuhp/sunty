package br.com.sunty.models.activity;

import br.com.sunty.models.activity.utils.Activity;
import br.com.sunty.models.section.Section;

public class Explanation extends Activity {

    private String text;

    public Explanation(Long id, String name, String urlCode, Section section, String text) {
        super.setId(id);
        super.setName(name);
        super.setUrlCode(urlCode);
        super.setSection(section);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "text='" + text + '\'' +
                '}';
    }
}
