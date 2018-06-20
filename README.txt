To build the app:

mvn clean install

To run:

java -jar target/social-networking-app.jar

Run with debugger:

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 -jar target/social-networking-app.jar