package charles.spring.spring5recipeapp.controllers;

import charles.spring.spring5recipeapp.domain.Recipe;
import charles.spring.spring5recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    IndexController indexController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {

        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipeA = new Recipe();
        recipeA.setId(4L);
        recipes.add(recipeA);
        when(recipeService.getRecipesIterable()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewString = indexController.getIndexPage(model);

        //then
        assertEquals("index", viewString);
        verify(recipeService, times(1)).getRecipesIterable();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }


}