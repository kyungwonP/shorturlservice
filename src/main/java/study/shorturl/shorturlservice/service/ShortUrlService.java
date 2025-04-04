package study.shorturl.shorturlservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.shorturl.shorturlservice.domain.ShortUrls;
import study.shorturl.shorturlservice.repository.ShortUrlRepository;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShortUrlService {

    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private final ShortUrlRepository repository;

    public String redirectUrl(String key) {
        String shortUrl = getShortUrl(key);
        addCount(key); // event
        return shortUrl;
    }

    public void addCount(String key) {
        repository.addCount(key);
    }

    public String getShortUrl(String key) {
        return repository.getShortUrl(key);
    }

    public void createShortUrl(String url) {
        String key = createRandomKey();
        ShortUrls shortUrl = new ShortUrls(url, key);
        repository.createShortUrl(shortUrl);
    }

    public List<ShortUrls> getShortUrls() {
        return repository.getShortUrls();
    }

    private String createRandomKey() {
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        return randomGenerator
                .ints(8, 0, CHARACTERS.length())
                .mapToObj(i -> String.valueOf(CHARACTERS.charAt(i)))
                .collect(Collectors.joining());
    }
}
