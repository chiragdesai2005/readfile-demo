# Readfile-demo
Build a Spring Boot Batch application that take two input parameters, the first
one is path to a text file, the second one is number of threads.

- Prerequisites softwares
    - JDK 1.8 or higher
    - Apache maven 3.0 or higher

- How to build the application
   open terminal/command window and run 'mvn clen install' command from the application's home directory 
   run Springboot application from intellij/eclispe or directly run fat jat from target folder after successful build.

- How to run the application

    This is a batch appllication without scheduler
    Application expect exact 2 arguments
    1 - Fully qualified file path
    2 - Number of thread count
    
- Assumptions
   - File size is not too big like in GB or TB
   - Writing file location is in the current application directory
   
   
       