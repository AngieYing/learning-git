package study.tacocloud.web;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import study.tacocloud.*;


@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order",new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(Order order){
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
