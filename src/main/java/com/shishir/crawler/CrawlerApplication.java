package com.shishir.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;


@SpringBootApplication
public class CrawlerApplication {
    @Value("${shishir.crawler.urls}")
    private String[] urls;

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
    }

    @PostConstruct
    @Scheduled(fixedDelay = 10000)
    public void crawlWebsite() {
        System.out.println("Shishir Web Crawler started.");
        Arrays.stream(urls).forEach(this::crawl);
        System.out.println("Shishir Web Crawler completed.");
    }

    @Async
    void crawl(String url) {
        System.out.println("Crawling for url: "+ url + " started");
        try {
            Document doc = Jsoup.connect(url).get(); // Fetch the HTML content of the page
            Elements links = doc.select("a[href]"); // Select all anchor tags

            for (Element link : links) {
                String href = link.attr("href");
                System.out.println(href);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Crawling for url: "+ url + " completed");
    }
}

@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "shishir.crawler.scheduling", name = "enabled", havingValue="true", matchIfMissing = false)
class SchedulingConfig {

}
