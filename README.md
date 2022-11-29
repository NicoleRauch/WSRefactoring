# WSRefactoring

## Setup

### Java
Install Java: https://www.oracle.com/de/java/technologies/downloads/

Java 16 is required to compile all example solutions; to participate in
the workshop, Java 8 is sufficient.

### IDE
You can use any IDE or editor to participate in the workshop.

If you are interested in using a good Java IDE, you can download IntelliJ: https://www.jetbrains.com/idea/download (the community edition is free).

### For Windows

Run the production code:

```
cd src
javac start\*.java
java start.DiscountCalculator
```

Run the tests:

```
cd test
javac start\*.java
java -cp .;..\src;..\lib\junit-4.13.2.jar;..\lib\hamcrest-all-1.3.jar org.junit.runner.JUnitCore start.DiscountCalculatorTest
```

### For Linux and MacOS

Run the production code:

```
cd src
javac start/*.java
java start.DiscountCalculator
```

Run the tests:

```
cd test
javac start/*.java
java -cp .:../src:../lib/junit-4.13.2.jar:../lib/hamcrest-all-1.3.jar org.junit.runner.JUnitCore start.DiscountCalculatorTest
```

