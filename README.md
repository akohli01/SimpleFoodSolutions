# Overview
This is a RESTFul web service that is used by a fictional company called Simple Food Solutions. The primary functions of this service are to provide recipe information via keyword. This service will return JSON data that can be processed and used.


# Technologies used
1. Java EE - JAX-RS with Jersey Implementation
2. Hibernate 
3. MySQL database with recipe information

# To get started 
1. Use Intellij IDEA as the preferred IDE
2. Import as a Maven project
3. Download Tomcat or Tomcat EE and configure with Intellij
4. Contact me about database files (email: amitkohli.official@gmail.com)


# Requesting Data
http://*hostname:port*/recipesearchapi/api/search/recipe/title/*recipe_keyword*

hostname:port - replace with your hostname and port (example - localhost:8080)
recipe_keyword - replace with recipe you are looking for

# Return Data 
Return data will be JSON and will be in the following format (example of searching for apple):

```
{
        "id": 19,
        "title": "Candied Brie With Apple Wedges",
        "description": "<h1>Candied Brie with Apple Wedges</h1><p>One (4-inch) round brie cheese<br>1 tablespoon unsalted butter<br>2 tablespoons packed light brown sugar<br>Juice of 1/2 lemon<br>1 large tart apple, such as Granny Smith, cut into about 12 wedges<br>5 pecan halves</p><p>Preheat the oven to 275 degrees F.</p><p>Place the brie on a baking sheet. Bake for about 15 minutes, or until softened and warm.</p><p>Meanwhile, melt the butter in a small nonstick saucepan over medium heat. Reduce the heat to medium-low; add the brown sugar and stir occasionally until melted.</p><p>Make acidulated water by mixing the lemon juice into a small bowl of water. Dip the apple wedges into the water.</p><p>Place the warm cheese in a small serving bowl or on a small plate. Drizzle with the warm sauce. Garnish with the pecans in a pinwheel formation. Surround the cheese with the apple wedges.</p>"
}
```

# Directory breakdown

 - src/main - the central location for the project files
 - src/main/webapp - contains web configuration such as WEB_INF directory with a web.xml file
 - src/main/resources - contains the hibernate.cfg.xml file (needed for hibernate configuration)
 - src/main/java/online/simnplefoodsolutions/api - contains api code files
 - src/main/java/online/simnplefoodsolutions/api/dao/ - contains data access objects that are needed to authenticate the client and to retrieve recipe information from the database
 -  src/main/java/online/simnplefoodsolutions/api/entity/ - contains classes that map to database tables
 -  src/main/java/online/simnplefoodsolutions/api/filter/ - checks that client is authorized to use web service resources
 -  src/main/java/online/simnplefoodsolutions/api/resouceconfig/ - contains the class that will bootstrap the application
 -  src/main/java/online/simnplefoodsolutions/api/resource/ - contains the web service resource
 - src/main/java/online/simnplefoodsolutions/api/utility/ - contains helper classes for this application





























