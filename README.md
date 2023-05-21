# Recipe Management Application
This is a standalone Java application that allows users to manage their favorite recipes. It provides a REST API for adding, updating, removing, and fetching recipes. Users can also filter available recipes based on various criteria such as vegetarian status, number of servings, specific ingredients, and text search within the instructions.

## Architecture
The recipe management application follows the MVC (Model-View-Controller) architecture. It consists of the following components:

Controller Layer: The RecipeController class handles HTTP requests and coordinates the flow of data between the Model and the View.
Service Layer: The RecipeService class represents the service layer. It contains methods for adding, updating, deleting, fetching, and filtering recipes. It coordinates with the Repository to perform data access operations.
Repository Layer: The RecipeRepository class acts as the Repository layer and handles the data access operations.
Model Layer: The Recipe class represents the data model for a recipe in the application.
The application uses an H2 in-memory database to store data in memory instead of persisting it on disk.

##Technologies Used
The application is developed using the following technologies:

Java
Spring Boot
RESTful API
MySQL
Spring Data JPA
JUnit
Easymock
##Accessing the Endpoints
The application provides several endpoints to perform various operations:

1). Users can add a new recipe by sending a POST request to the /recipes endpoint with the recipe details in the request body. The URL would be http://localhost:8080/recipes. Here's an example JSON body for adding a recipe:

json

`{
  "name": "Salmon Fry in Oven",
  "ingredients": ["salmon", "spices", "mint"],
  "instructions": "Preheat the oven to 400°F (200°C). Season the salmon with spices and marinate for 15 minutes. Bake in the preheated oven for 12-15 minutes or until the salmon is cooked through. Garnish with fresh mint leaves and serve hot.",
  "vegetarian": false,
  "servings": 4
}` <br>
2). Users can update a recipe by sending a PUT request to the /recipes/{recipeId} endpoint, where {recipeId} is the ID of the recipe to be updated. Url is `http://localhost:8080/recipes/{recipeId}'. Example of JSON body for updating a recipe:

json
`
{
  "name": "Salmon Fry in Oven",
  "ingredients": ["salmon", "spices", "mint"],
  "instructions": "Preheat the oven to 400°F (200°C). Season the salmon with spices and marinate for 15 minutes. Bake in the preheated oven for 12-15 minutes or until the salmon is cooked through. Garnish with fresh mint leaves and serve hot.",
  "vegetarian": false,
  "servings": 4
} ` <br>
3). Users can delete a recipe by sending a DELETE request to the /recipes/{recipeId} endpoint, where {recipeId} is the ID of the recipe to be deleted. Url is `http://localhost:8080/recipes/{recipeId}`. <br>

4). Users can filter recipes by the number of servings using the /recipes/servings/{count} endpoint. This endpoint returns recipes with the specified number of servings. Url is `http://localhost:8080/recipes/servings/{count}`.

5). Users can filter recipes by instructions using the /recipes/instructions endpoint with a keyword query parameter. This endpoint returns recipes that contain the specified keyword in the instructions. Url is `http://localhost:8080/recipes/instructions?keyword=oven`.

6). Users can filter recipes by including or excluding specific ingredients using the /recipes/ingredients endpoint with include and exclude query parameters. This endpoint returns recipes that include the specified ingredients and exclude the specified ingredients. Url is `http://localhost:8080/recipes/ingredients?include=salmon&exclude=tomatoes`.

7). Users can retrieve all recipes by sending a GET request to the /recipes endpoint. The URL is `http://localhost:8080/recipes`.

The Swagger UI interface is available at http://localhost:8080/swagger-ui/index.html, which allows users to interact with the API endpoints visually.
