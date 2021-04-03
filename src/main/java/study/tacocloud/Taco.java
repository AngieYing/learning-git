package study.tacocloud;

import lombok.*;

import javax.validation.constraints.*;
import java.util.*;

@Data
public class Taco {
    @NotNull
    @Size(min=6, message="Name must be more than 6 characters long")
    private String name;

    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;

}
