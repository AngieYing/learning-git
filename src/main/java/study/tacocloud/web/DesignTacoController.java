package study.tacocloud.web;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import study.tacocloud.*;
import study.tacocloud.Ingredient.Type;

import java.util.*;
import java.util.stream.*;

@Slf4j // Lombok-provided annotation,automatically generate Sample logging Facade for Java at runtime,
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for(Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }
        model.addAttribute("design",new Taco());
        return "design";

    }
    @PostMapping
    public String processDesign(Taco design){
        log.info("Processing design:" + design);
        return "redirect:/orders/current";
    }
}
