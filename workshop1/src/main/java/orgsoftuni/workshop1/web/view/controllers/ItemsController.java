package orgsoftuni.workshop1.web.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @GetMapping("/create")
    public String getItemCreateForm() {
        return "items/create-item.html";
    }
    @GetMapping("/merchant")
    public String getItemMerchant() {
        return "items/merchant.html";
    }
}

