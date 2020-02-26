# Overview
This is an enterprise application for a fictional company called Simple Food Solutions. The primary functions of this application are to provide reporting, searching for recipes, and management of user accounts. This project uses multiple modules that are packaged into an ear and can be deployed to a application server. In addition this project follows the MVC design pattern and is monolithic in nature.


# Technologies used
1. Java EE  
        a. JSF (MyFaces, Primefaces)  
        b. JSON-B (Jackson)  
        c. JavaMail  
2. Hibernate 
3. MySQL database for storing user account information
4. JUnit 5
5. Apache Commons

# To get started 
**Prerequisite:
Setup recipesearchapi (available as another repository on my github)**
1. Use Intellij IDEA as the preferred IDE
2. Import as a Maven project
3. Download Tomcat EE and configure with Intellij
4. Contact me about database files (email: amitkohli.official@gmail.com)


# Module breakdown

- report-module/ - contains code for reporting 
- search-module/ - contains code for retrieving recipe information from a web service
- user-accounts-module/ - contains code for managing user accounts
- utility-module/ - contains helper classes for this application
- web-module/ - contains the web application
- simplefoodsolutions-ear - uses all the above modules to create the enterprise application




























