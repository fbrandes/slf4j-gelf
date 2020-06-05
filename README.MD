# slf4j-gelf 

[![Build Status](https://travis-ci.org/fbrandes/slf4j-gelf.svg?branch=develop)](https://travis-ci.org/fbrandes/slf4j-gelf)

[slf4j-gelf](https://github.com/fbrandes/slf4j-gelf) provides the capability of creating [GELF-formatted](https://docs.graylog.org/en/latest/pages/gelf.html) log messages via SLF4J. 

## Getting Started
slf4j-gelf requires Java 11.

### Installation
Maven: 
```xml
<dependency>
  <groupId>com.github.fbrandes</groupId>
  <artifactId>slf4j-gelf</artifactId>
  <version>0.0.1</version>
</dependency>
```

Gradle: 
```gradle
dependencies {
  implementation("com.github.fbrandes:slf4j-gelf:0.0.1")
}
```

### Usage
With slf4j-gelf loggers can be created similar to SLF4J but instead of ```LoggerFactory``` there is ```GelfLoggerFactory```.
```java
private static final Logger LOGGER = new GelfLoggerFactory().getLogger(Log4jTest.class);
LOGGER.info("foo");
```