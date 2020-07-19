package charles.spring.spring5recipeapp.services;

import charles.spring.spring5recipeapp.domain.Recipe;

import java.util.List;
import java.util.Set;


public interface RecipeService  {

    Set<Recipe> getRecipes();

    List<Recipe> getRecipesList();

    Iterable<Recipe> getRecipesIterable();

}
