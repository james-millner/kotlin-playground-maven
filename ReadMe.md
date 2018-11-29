# Kotlin hello-world example with maven

## Prerequisites to running the example

 * download Maven directly from the [Apache Maven homepage](http://maven.apache.org/download.html)
 * install and configure your system as described in [the installation section](http://maven.apache.org/download.html#Installation)

## Compiling/Testing/Running the example

If you have maven on your path, simple type:

	mvn test
	
It will compile:
 * src/main/kotlin/MarvelApi.kt into target/classes/hello/MarvelApiKt.class
 * src/test/kotlin/MarvelApiTest.kt into target/test-classes/hello/tests/HelloTest.class

Then run tests, and finally run your main MarvelApiKt class.

## Only running the example

Once you compiled the sources with previous 'mvn test' command, you can run the application by typing:

	mvn exec:java

Alternatively, once built you can run the example with the kotlin CLI
    
    kotlin -cp target/marvel-api-kotlin-example-1.0-SNAPSHOT-jar-with-dependencies.jar MarvelApiKt agr1 arg2 ....... 
    
Or you can run with Java once built:

    java -jar target/marvel-api-kotlin-example-1.0-SNAPSHOT-jar-with-dependencies.jar agr1 arg2 ....... 
	
## Using commandline arguments

If you want to modify the main method in Hello.kt in order to use commandline arguments, you can specify them on commandline as:

	mvn exec:java -Dexec.args="argument1"


