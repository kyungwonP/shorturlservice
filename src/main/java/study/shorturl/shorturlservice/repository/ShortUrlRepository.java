package study.shorturl.shorturlservice.repository;

import org.springframework.stereotype.Repository;
import study.shorturl.shorturlservice.domain.ShortUrls;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShortUrlRepository {

    private final List<ShortUrls> shortUrls = new ArrayList<>();
    private Long showCount = 0L;

    public void addCount(String key) {
        shortUrls.stream().filter(x -> x.getKey().equals(key)).findFirst().ifPresent(x -> x.setCallCount(x.getCallCount() + 1));
    }

    public String getShortUrl(String key) {
        ShortUrls shortUrl = shortUrls.stream().filter(x -> x.getKey().equals(key)).findFirst().orElseThrow();
        return shortUrl.getUrl();
    }

    public void createShortUrl(ShortUrls ShortUrl) {
        shortUrls.add(ShortUrl);
    }

    public List<ShortUrls> getShortUrls() {
        return shortUrls;
    }
}
