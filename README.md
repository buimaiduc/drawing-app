# drawing-app

###1. PURPOSE###

The purpose of this document is to provide the solution for building a simple console version of a drawing program
which fulfills the non-functional requirements on Backend and instructions required to build and run the application.

###2. REQUIREMENT###

Create a simple console version of a drawing program.
At this time, the functionality of the program is quite limited but this might change in the future.
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit

###3. SOLUTION###

Since this application is just the console application which is not necessary to to apply many any frameworks. The main
point is that we need to design the structure of the application that can be easy to extend, maintain, scale out/up later.

-   Every single entity will be declared seperately which can be used for mapping(ORM) later.
-   Seperate out the layers of the application(service, application...) so that it can extend easily.

###4. DESIGN###

Applicatiom modules:

-   constant: contain all constant values which used on the whole application
-	exception: exception handlers for the whole application
-	model: contain all data models used on this application (Dataset, DatasetType…) which can be used for mapping(ORM) later.
-	service: implementation on service layer
-   util: contain utility/helper classes (StringUtils, CollectiomUtils…)

Application diagram:

-   The core implementation in this application is the DrawService implementation which is define to be generic by following OOP for this design.
It just contains 2 basic methods: validate, draw. Based on each type of input, output, it will have its own bahavior. By following this design it
can be extended by another draw services.
For example: LineDrawService<Line, Canvas>, RectangleDrawService<Rectangle, Service>...
-   DrawServicePopulator is the template which defines all steps to get the drawn shape(which is applied template design pattern)

###4. UNIT TEST###

-	To check the correctness of calculated the canvas values in this program, we use JUnit as a unit test framework for
checking the functionalities related drawing canvas value.
-	The test will compare the result, expected value and expected deviation (between result value and expected value).
Depending on this comparison, the test result will return true or false.

###5. RUN APPLICATION WITH JAR FILE###

On the application folder, go the target folder and run the application:

-     $ java -jar drawing-app-1.0-SNAPSHOT.jar

###6. BUILD AND RUN INSTRUCTIONS###

Required environment variables: JAVA_HOME, MAVEN_HOME

Build the application using Maven.

Get code Clone the repository:

-     $ git clone https://github.com/buimaiduc/drawing-app

Build and run the application

-     $ cd drawing-app
-     $ mvn clean install
-     $ cd target
-     $ java -jar drawing-app-1.0-SNAPSHOT.jar


*** Notes: Screen_Shot_Result_1_0_SNAPSHOT.png for the execution example
