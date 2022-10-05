package com.cath.cathdemo.controller;

import com.cath.cathdemo.entity.CathCoin;
import com.cath.cathdemo.repository.CathCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CathCoinController {

    @Autowired
    CathCoinRepository cathCoinRepository;

    @GetMapping("/display")
    public String displayForm(){
        return "coindata";
    }

    @PostMapping("/add")
    public String insertCathCoin(CathCoin cathCoin, Model model){
        CathCoin saved = cathCoinRepository.save(cathCoin);
        model.addAttribute("coin", saved);

        return "coindata";
    }
}
