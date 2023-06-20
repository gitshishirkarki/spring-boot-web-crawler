# Web Crawler in Spring Boot

## Web Crawler
A web crawler, also known as a web spider or web scraper, is an automated script or program that systematically browses the internet to discover and index web pages. It starts from a given seed URL and follows hyperlinks on web pages to navigate and extract information from other pages. Web crawlers are widely used by search engines to gather data, index web pages, and provide relevant search results to users. They play a crucial role in the process of web indexing, data mining, and information retrieval from the vast expanse of the World Wide Web.

## Project Details
This is a Java-based web crawler application developed using Spring Boot. The application utilizes the Jsoup library to crawl websites. It supports scheduling, asynchronous crawling, and website URLs can be provided in the `application.properties` file.

## Features

1. Scheduling: The application allows scheduling the crawling process. This feature can be enabled or disabled from the properties file.
2. Asynchronous Crawler Method: The crawler method in the application is designed to work asynchronously, allowing efficient crawling of multiple websites.
3. Jsoup Integration: The Jsoup library is used to crawl the websites provided in the properties file.

## Prerequisites

- Java 8 or higher
- Gradle

## Build and Run

To build and run the project, follow these steps:

1. Clone the repository.
2. Navigate to the project directory.

```
cd spring-boot-web-crawler
```

3. Build the project using Gradle.

```
gradle build
```

4. Run the application.

```
gradle bootRun
```

The application will start running on `http://localhost:8080`.

## Configuration

The application can be configured using the `application.properties` file. Here are the available configuration options:

```properties
# Application configuration
spring.application.name=ShishirWebCrawler
# Application run port
server.port=8080

# Crawler Configuration
shishir.crawler.scheduling.enabled=true
shishir.crawler.urls=https://www.example1.com,https://www.example2.com
```

- `spring.application.name`: Specifies the name of the application.
- `server.port`: Defines the port on which the application will run.
- `shishir.crawler.scheduling.enabled`: Enables or disables scheduling for the crawler.
- `shishir.crawler.urls`: Specifies the URLs of the websites to crawl. Multiple URLs can be provided, separated by commas.

## Example

An example of the web crawler implementation can be found in the `CrawlerApplication` class.

This is a simple starting point for the application.

Feel free to explore and modify the code to suit your specific requirements.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

This project utilizes the following libraries:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Jsoup](https://jsoup.org/)

These libraries greatly simplify web crawling and development with Spring Boot.
