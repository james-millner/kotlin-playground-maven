# Kotlin hello-world example with maven

## Prerequisites to running the example

 * download Maven directly from the [Apache Maven homepage](http://maven.apache.org/download.html)
 * install and configure your system as described in [the installation section](http://maven.apache.org/download.html#Installation)

## Compiling/Testing/Running the example

If you have maven on your path, simple type:

	mvn test
	
It will compile:
 * src/main/kotlin/Hello.kt into target/classes/hello/HelloKt.class
 * src/test/kotlin/HelloTest.kt into target/test-classes/hello/tests/HelloTest.class

Then run tests, and finally run your main HelloKt class.

## Only running the example

Once built you can run the example with the kotlin CLI
    
    kotlin -cp target/hello-world-kotlin-example-1.0-SNAPSHOT-jar-with-dependencies.jar HelloKt
    
Or you can run with Java once built:

    java -jar target/hello-world-kotlin-example-1.0-SNAPSHOT-jar-with-dependencies.jar
    
