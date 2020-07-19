package charles.spring.spring5recipeapp.controllers;


import charles.spring.spring5recipeapp.repositories.CategoryRepository;
import charles.spring.spring5recipeapp.repositories.UnitOfMeasureRepository;
import charles.spring.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

//        Optional<Category> categoryOptional = categoryRepository.findByDescription("Chinese");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("wanng");
//
//        System.out.println("Category \"Chinese\" ID is: " + categoryOptional
//                .map(category -> categoryOptional.get().getId())
//                .orElse(-1L));
//        System.out.println("Unit of Measure \"wan\" ID is: " + unitOfMeasureOptional
//                .map(unitOfMeasure -> unitOfMeasureOptional.get().getId())
//                .orElse(-1L));

        model.addAttribute("recipes", recipeService.getRecipesIterable());
//        model.addAttribute("recipes", recipeService.getRecipesList());

        return "index";
    }
}
