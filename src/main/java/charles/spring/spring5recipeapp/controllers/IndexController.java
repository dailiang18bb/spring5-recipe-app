package charles.spring.spring5recipeapp.controllers;


import charles.spring.spring5recipeapp.domain.Category;
import charles.spring.spring5recipeapp.domain.UnitOfMeasure;
import charles.spring.spring5recipeapp.repositories.CategoryRepository;
import charles.spring.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Chinese");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("wanng");

        System.out.println("Category \"Chinese\" ID is: " + categoryOptional
                .map(category -> categoryOptional.get().getId())
                .orElse(-1L));
        System.out.println("Unit of Measure \"wan\" ID is: " + unitOfMeasureOptional
                .map(unitOfMeasure -> unitOfMeasureOptional.get().getId())
                .orElse(-1L));

        return "index";
    }
}
