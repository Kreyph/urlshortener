# Code Assignment: URL Shortener

This is a REST API URL shortener, implemented with Kotlin and Spring Boot.

## Overview

- **Create Short URL:**  
  `POST /api/urls` accepts the original URL and returns the full URL in the location header of the response.
- **Redirect to the Original URL:**  
  `GET /{shortCode}` redirects the client to the original URL when an existing shortened code is provided.
- **Error Handling:**  
  Provides basic exception handling to cover a few common error cases.
- **Profiles and Configuration:**  
  Provides the properties for the dev environment to work - the prod configuration would be overridden and externalised by other configurations (e.g. Docker, production DB, etc.)
- **Caching:**  
Caches the URLs resolutions with Spring; the production strategy has to be defined at a later point.

## Getting Started

### Prerequisites

- JDK 17 or later
- Maven 3.6+
- Git

## Used Resources

- [Spring Docs](https://docs.spring.io/spring-framework/reference/index.html)
- [Spring Initializr](https://start.spring.io/)
- [Random String implementation quick check](https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java)

### Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Kreyph/urlshortener.git
   cd urlshortener
