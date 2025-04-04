package study.shorturl.shorturlservice.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShortUrls {
    private String key;
    private String url;
    private Long callCount;

    public ShortUrls(String url, String key) {
        this.url = url;
        this.key = key;
        this.callCount = 0L;
    }
}
