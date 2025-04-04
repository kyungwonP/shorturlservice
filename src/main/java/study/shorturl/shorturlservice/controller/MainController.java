package study.shorturl.shorturlservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.shorturl.shorturlservice.service.ShortUrlService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ShortUrlService shortUrlService;

    @GetMapping("/")
    public String mainForm() {
        return "main/main";
    }

    @GetMapping("/{key}")
    public String redirectUrl(@PathVariable("key") String key) {
        String redirectUrl = shortUrlService.redirectUrl(key);
        return "redirect:" + redirectUrl;
    }

}
