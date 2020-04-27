package org.softuni.initialproject.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cars")
public class CarController {

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create");
    }

    @PostMapping("/create")
    public ModelAndView createConfirm() {

    }
}
