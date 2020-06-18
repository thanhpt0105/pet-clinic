package com.thanhpt0105.petclinic.controllers;

import com.thanhpt0105.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/", ""})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/ownerList";
    }
}