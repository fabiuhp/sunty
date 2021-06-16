package br.com.sunty.models.activity;

import br.com.sunty.models.section.Section;

import static br.com.sunty.models.validations.Validation.*;

public class Video extends Activity {

    private String url;
    private Integer time;
    private String transcription;

    public Video(String name, String urlCode, Section section, String url) {
        super(name, urlCode, section);

        nonEmptyFieldValidation(url, "Url");
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    @Override
    public String toString() {
        return "Video{" +
                "url='" + url + '\'' +
                ", time=" + time +
                ", transcription='" + transcription + '\'' +
                '}';
    }
}
