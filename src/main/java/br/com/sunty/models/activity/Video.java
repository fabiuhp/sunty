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
@Table(name = "video")
@Data
@NoArgsConstructor
public class Video extends Activity {

    private String url;
    private String time;
    private String transcription;

    public Video(String name, String urlCode, Section section, String url) {
        super(name, urlCode, section);
        notBlank(url);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
