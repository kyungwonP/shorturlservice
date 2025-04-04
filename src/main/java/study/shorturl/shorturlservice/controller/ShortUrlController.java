package study.shorturl.shorturlservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.shorturl.shorturlservice.domain.ShortUrls;
import study.shorturl.shorturlservice.service.ShortUrlService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping("/short-url")
    public void createShortUrl(@RequestBody String url) {
        shortUrlService.createShortUrl(url);
    }

    @GetMapping("/short-urls")
    public List<ShortUrls> getShortUrls() {
        return shortUrlService.getShortUrls();
    }
}
