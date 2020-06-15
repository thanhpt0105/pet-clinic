package com.thanhpt0105.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"/", ""})
    public String listVets() {
        return "owners/ownerList";
    }
}
