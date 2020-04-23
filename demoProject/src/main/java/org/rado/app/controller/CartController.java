package org.rado.app.controller;

import org.rado.app.db.entity.Item;
import org.rado.app.db.entity.Product;
import org.rado.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String cart(HttpSession session) {
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ArrayList<>());
        }

        return "cart";
    }

    @GetMapping("/buy/{id}")
    public String buyConfirm(@PathVariable String id, HttpSession session) {
        Product product = this.productService.getProductById(id);
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<>();
            cart.add(new Item(product, 1));
            session.setAttribute("cart", cart);
        } else {
            @SuppressWarnings("unchecked")
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(product, 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }

            session.setAttribute("cart", cart);
        }

        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeConfirm(@PathVariable String id, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    private int exists(String id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}
