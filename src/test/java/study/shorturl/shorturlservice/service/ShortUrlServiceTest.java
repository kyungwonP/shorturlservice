package study.shorturl.shorturlservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.shorturl.shorturlservice.domain.ShortUrls;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ShortUrlServiceTest {

    @Autowired
    private ShortUrlService shortUrlService;

    @Test
    public void redirectUrl() {
        // given
        String url = "http://digitalmnc1.com";
        shortUrlService.createShortUrl(url);
        List<ShortUrls> shortUrls = shortUrlService.getShortUrls();
        ShortUrls shortUrls1 = shortUrls.get(0);

        // when
        String redirectUrl = shortUrlService.redirectUrl(shortUrls1.getKey());

        // then
        assertTrue(url.equals(redirectUrl));
    }

    @Test
    public void createShortUrl() {
        // given
        String url = "http://digitalmnc1.com";
        shortUrlService.createShortUrl(url);

        // when
        List<ShortUrls> shortUrls = shortUrlService.getShortUrls();

        // then
        assertTrue(shortUrls.size() == 1);
        assertTrue(shortUrls.get(0).getUrl().equals(url));
    }

    @Test
    public void getShortUrls() {
        // given
        shortUrlService.createShortUrl("http://digitalmnc1.com");
        shortUrlService.createShortUrl("http://digitalmnc2.com");

        // when
        List<ShortUrls> shortUrls = shortUrlService.getShortUrls();

        // then
        assertTrue(shortUrls.size() == 2);
    }

}