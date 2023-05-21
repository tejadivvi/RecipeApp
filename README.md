#Recipe Management application :
This is  a standalone java application which allows users to manage their favourite recipes. It has a REST API for adding, updating, removing, and fetching recipes. Additionally, users can also filter available recipes based on different criteria as specified in the requirements (vegetarian status, number of servings, specific ingredients, and text search within the instructions).

##Architecutural Decisions

Recipe management application follows MVC Architecture which has the components
Controller Layer, Service Layer, Repository Layer, Model Layer. <br> `RecipeController` class handles Http requests and coordinates the flow of data between the Model and the View. <br> `RecipeService` class represents the service layer. It contains methods for adding, updating, deleting, fetching and filtering recipes. It coordinates with the Repository to perform data access operations. <br> `RecipeRepository` class acts as a Repository layer which handles the data access operations. <br> `Recipe` class represents the data model for a recipe in our application. 
<br>I have used H2 in-memory database for storing data in memory instead of storing on disk. 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
##Techonologies used 

`Java`, `SpringBoot`, `Restful API` `Mysql`, `Spring Data JPA`, `Junit`, `Mockito`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
 
##Accessing the endpoints                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
1). Users can add a new recipe by sending a POST request to the `/recipes` endpoint with the recipe details in the request body. 
<br> Url: POST `http://localhost:8080/recipes` Json Body:
`` {
     "name": "Salmon Fry in Oven",
     "ingredients": ["salmon", "spices", "Mint"],
     "instructions": "Preheat the oven to 400°F (200°C). Season the salmon with spices and marinate for 15 minutes. Bake in the preheated oven for 12-15 minutes or until the salmon is cooked through. Garnish with fresh mint leaves and serve hot.",
     "vegetarian": false,
     "servings": 4
   }

 `` <br>
 2). User can update the recipe using this endpoint. <br> Url PUT `http://localhost:8080/recipes/{recipeId}` <br> Json Body: `` {
                                                                                                                                     "name": "Salmon Fry in Oven",
                                                                                                                                     "ingredients": ["salmon", "spices", "Mint"],
                                                                                                                                     "instructions": "Preheat the oven to 400°F (200°C). Season the salmon with spices and marinate for 15 minutes. Bake in the preheated oven for 12-15 minutes or until the salmon is cooked through. Garnish with fresh mint leaves and serve hot.",
                                                                                                                                     "vegetarian": false,
                                                                                                                                     "servings": 4
                                                                                                                                   }
                                                                                                                              ``
                                                                                                                              
 3).User can delete the recipe using this endpoint. <br> Url: DELETE `http://localhost:8080/recipes/{recipeId}`        
 4).User can filter the recipe by servings using this endpoint<br> Url: GET `http://localhost:8080/recipes/servings/{count}` 
 5). User can filter the recipes with instructions using this endpoint <br> Url: GET `http://localhost:8080/recipes/instructions?keyword=oven`                                                                                                                   
 6). User can filter the recipes either by specifyin including or excluding the ingredients using this endpoint. <br>
 GET `http://localhost:8080/recipes/ingredients?include=salmon&exclude=tomatoes`
 7). User can get all the recipes using this endpoint. <br>
 Url: GET `http://localhost:8080/recipes`
 <br>
 7). Swagger UI interface for interacting with all these endpoints is accessible with this endpoint <br>
 `http://localhost:8080/swagger-ui/index.html`
 
                                