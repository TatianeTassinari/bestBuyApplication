### bestBuyApplication

### Project description:

### This project was created to test and validate CRUD scenarios to the Best Buy API Playground: https://github.com/bestbuy/api-playground

### The project was created using the IntelliJ IDEA Community Edition 2018.2 and Gradle as dependency management in Windows 7 (Please, take in consideration this QA doesn't have access to an Apple Mac Book).

### The project uses the following set of artifacts and their respective versions as defined in the build.gradle:

### JUnit having version 4.12
### java having version 1.7 or more

### Decision about how to handle test data:
### CategoryID is being created automatically and randomly as you can see in the class GenerateRandomCategorieID.

### Assumptions
### You have an IDEA compatible with gradle already setup and running in your machine.
### You have the BestBuy API up and running in your local machine in: http://localhost:3030

### How to execute the project:
#### After checkout the project to your machine and open it with the IDEA and guarantee is everything ok related to the gradle dependencies, you have two ways to run the tests:
### Option 1: Open the package src/test/java/automationAPI, and Run it directly clicking with right button and choosing: Run 'Tests in 'automationAPI'
### Option 2: Play diretly in Run/Debug configuration dialog with the option: automationAPI in test.automation.api_test

### Framework:
### The test cases were creted using Rest assured.

### Test Cases that were automated:
### Based on swagger documentation to BestBuy API, we've tried to automate as much scenarios as possible, mostly related to CRUD operations to the endpoints:
### - products
### - stores
### - services
### - categories
### - utilities


### What’s next?
### 1)	Refactor the code to reuse the methods as much as possible and don’t have test data hard coded inside the methods. We could use properties file or external json file, for example.
### 2)	Fix the current method where we call the endpoint to create a category, it’s generating random id correctly (because the id must have unique value), but it’s not saving in the API database.


#### Project Author: Tatiane Tassinari (tatianetassinari85@gmail.com)
