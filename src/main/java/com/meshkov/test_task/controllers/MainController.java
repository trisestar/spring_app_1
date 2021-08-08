package com.meshkov.test_task.controllers;

import com.meshkov.test_task.dao.PolicyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final PolicyDao policyDao;

    @Autowired
    public MainController(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }


    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/policies")
    public String allPolicies(Model model){
        model.addAttribute("policies", policyDao.loadAll());
        return "policies";
    }
}
