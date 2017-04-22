[Building Java Web Applications using Gradle](https://guides.gradle.org/building-java-web-applications)

You can build and deploy the application to the default (Jetty) container by using the *appRun* task:

`> gradlew appRun`

You can access the web application at [*http://localhost:8080/gradle*](http://localhost:8080/gradle)

You can test the servlet using Gradle with the *test* task (or any task, like *build*, that depends on it):

`> gradlew test`

The test output can be accessed from `build/reports/tests/test/index.html`