# Code Assignment: URL Shortener

This is a URL shortener implemented with Kotlin and Spring Boot. It provides a REST API for shortening URLs and a resolution mechanism to redirects users to the original URL.

## Usage

- **Create Short URL:**  
  `POST /api/urls` accepts a JSON payload with the original URL and returns a simple response with the full URL in the location header.
- **Redirect to the Original URL:**  
  `GET /{shortCode}` redirects the client to the original URL.
- **Responses, Validation & Exception Handling:**  
  Basic exception handling is implemented to cover some common error cases (like an invalid URL provided or a non-existing shortened URL requested).
- **Profiles and Configuration:**  
  The necessary properties for the dev and the prod environments are provided, and they could be overridden and externalised by other configurations (e.g. Docker).
- **Scalability and further considerations:**
    - **Caching:** caches the URLs resolutions with Spring; the production strategy has to be defined at a later point, possibly with Redis.

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
   git clone <repository-url>
   cd url-shortener
