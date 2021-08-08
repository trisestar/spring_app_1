package com.meshkov.test_task.controller;

import com.meshkov.test_task.dao.PolicyDao;
import com.meshkov.test_task.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PolicyController {
    private final PolicyDao policyDao;

    @Autowired
    public PolicyController(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/policies")
    public String allPolicies(Model model) {
        model.addAttribute("policies", policyDao.loadAll());
        return "policies";
    }

    @GetMapping("/policies/add")
    public String addPolicy(@ModelAttribute("policy") Policy policy) {
        return "add_policy";
    }

    @PostMapping("/policies")
    public String addPolicyToDB(@ModelAttribute("policy") Policy policy) {
        policyDao.addPolicy(policy);
        return "redirect:/policies";
    }
}
