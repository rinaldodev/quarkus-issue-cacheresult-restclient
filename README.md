# Quarkus Issue

RestClient doesn't work OOTB with @CacheResult.

`./mvnw quarkus:dev`

Everytime you call:

`GET http://localhost:8080/fruits`

You get a different result. It is not cached by `@CacheResult`.
