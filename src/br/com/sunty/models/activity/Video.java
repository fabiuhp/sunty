package br.com.sunty.models.activity;

import br.com.sunty.models.activity.utils.Activity;
import br.com.sunty.models.section.Section;

public class Video extends Activity {

    private String url;
    private Integer time;
    private String transcription;

    public Video(Long id, String name, String urlCode, Section section, String url) {
        super.setId(id);
        super.setName(name);
        super.setUrlCode(urlCode);
        super.setSection(section);
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
