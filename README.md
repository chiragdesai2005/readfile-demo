# Readfile-demo
Build a Spring Boot Batch application that take two input parameters, the first
one is path to a text file, the second one is number of threads.

- Prerequisites softwares
    - JDK 1.8 or higher
    - Apache maven 3.0 or higher
    
- Test cases
    - I have tried to add test cases for encryption, file validator and writer
    - Similarly I can add more test cases for other classes as well like FileExecutor.java    

- How to build the application
   open terminal/command window and run 'mvn clen install' command from the application's home directory 
   run Springboot application from intellij/eclispe or directly run fat jat from target folder after successful build.

- How to run the application

    This is a batch application without scheduler
    Application expect exact 2 arguments
    1 - Fully qualified file path - for example - /Users/chirag/tt.txt
    2 - Number of thread count - for example - 5
    
    Command - mvn spring-boot:run  -Dspring-boot.run.arguments="/Users/chirag/tt.txt,5"
    
- Assumptions
   - File size is not too big like in GB or TB
   - Writing file location is in the current application directory
   - We can add more number of test cases for each and every line to cover functionality and code coverage
   
   
       