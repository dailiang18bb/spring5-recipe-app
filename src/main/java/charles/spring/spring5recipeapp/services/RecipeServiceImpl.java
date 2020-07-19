package charles.spring.spring5recipeapp.services;

import charles.spring.spring5recipeapp.domain.Recipe;
import charles.spring.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet :: add);
        return recipeSet;
    }

    @Override
    public List<Recipe> getRecipesList() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @Override
    public Iterable<Recipe> getRecipesIterable() {
        return recipeRepository.findAll();
    }
}
