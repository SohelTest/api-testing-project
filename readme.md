------------------------------------------------------------api-testing-project-------------------------------------------------------------------------------


GitHub link to the project : https://github.com/SohelTest/api-testing-project/tree/master

Below are the details of API-Testing-Project :

--> Used hybrid framework for creating automation script


--> Technologies and Applications used for Automation testing of API:- 
        JAVA
        Selenium 
        TestNG
        JUnit
        Maven
        Eclipse

--> Technologies and Applications used for Manual testing of API:-
        Json
        Javascript
        Chai Assertion Library
        Postman

--> All Path's :  
        
        Mock API --> "api-testing-project\mock-apis\Online-Book-Store.API_collection"
        Reports of Manual Testing of API --> "C:\Users\ADMIN\Documents\api-testing-project\mock-apis\Reports\newman"
        Automation script folder -->  "api-testing-project\tests\OnlineBookStore"
        Keyword folder is --> "C:\Users\ADMIN\Documents\api-testing-project\tests\OnlineBookStore\src\test\java\properties\config"
        Automation test script --> "C:\Users\ADMIN\Documents\api-testing-project\tests\OnlineBookStore\src\test\java\api\test"
        Automation payload code --> "C:\Users\ADMIN\Documents\api-testing-project\tests\OnlineBookStore\src\test\java\api\payload"
        Automation endpoints, routes, base class --> "C:\Users\ADMIN\Documents\api-testing-project\tests\OnlineBookStore\src\test\java\api\endpoints"


-------------------------------------------Steps to run Manual Testing and Automation Testing of API-------------------------------------------------------------


--> Steps to test Manual testing of API:-
     
     Open Online-Book-Store.API_collection using Postman or import it from Postman
     Open the Runner from the bottom of the Postman application
     Drag and drop the collection into the runner
     Select the API :
           UserRegistration
           User Login
           Search Books
           Add to Cart
           Checkout
     Select the iteration and click on "Start Run"

--> Alternate Step to run the Manual testing of API:-
     
     Go to the above mentioned path of the Mock API 
     Open command prompt in that folder
     Run the command --> "newman run api-testing-project\mock-apis\Online-Book-Store.API_collection"
     The Results will display on the command prompt

--> Step to create reports of Manual Testing of API:-
     
     Go to the above mentioned path of the Mock API 
     Open command prompt in that folder
     Run the command --> "newman run api-testing-project\mock-apis\Online-Book-Store.API_collection -r htmlextra"
     The Results will display on the command prompt

--> Steps to perform automation testing of API:-
    
    Open the OnlineBookStore using Eclipse or import it in the Eclipse Application
    Go to the TestNG.xml and run using TestNG suite OR Go to the pom.xml and run as the Maven test
    The Results will display in console
    
---------------------------------------------------Steps to perform CI/CD Pipeline of Automation Testing-------------------------------------------------------------

--> GitHub : 
     
     Go to the above mentioned path of the automation test script
     Open command prompt in that folder
     Enter commands --> 
          "git init" (To initiate the GitHub in the folder)
          "git config -- global user.name "name"" (To config with the username of the GitHub account)
          "git config -- global user.email "email"" (To config with the email of the GitHub account)
          "git status" (To check the status)
          "git add -A" (To add all files in the github)
          "git add filename.java" (To add a specific file)
          "git add *.java" (To add all java files)
          "git add foldername" (To add a folder in github)
          "git commit -m "API-Testing-Commit""
     
     Go to the GitHub webpage or Application 
     Create Repository in the GitHub
     Copy the url of the GitHub repository
     Enter commands -->
           "git remote add origin "url""
           "git push -u origin master"

     Then the code is pushed to the GitHub Repository

--> Jenkins :
     
     Download jenkins.war file from any browser
     Go to the specific folder of jenkins.war
     Open command prompt in the specific folder
     Enter command --> "Run java -jar jenkins.war" 
     Then the Jenkins will start running on the default port i.e. "http://localhost:8080/"
     Open Jenkins on the browser 
     Create a new job in Jenkins
     Name it and select Maven
     In General under Git put the github test script url
     Under Root POM, enter pom.xml
     Under goals and options enter clean test
     Apply and Save
     Click on Build now to start the test

     Global tool configuration in Jenkins:-
        JDK installations
        Git installations
        Maven installations
        
         
