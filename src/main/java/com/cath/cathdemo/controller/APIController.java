package com.cath.cathdemo.controller;

import com.cath.cathdemo.bean.CoinBean;
import com.cath.cathdemo.bean.MyCoin;
import com.cath.cathdemo.utils.CoinChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class APIController {

    @Value("${cath.coindesk.url}")
    private String apiURL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/displaycoindesk")
    public String getNewCoinDesk(Model model) {

        String updateTime = null;
        List<MyCoin> coinlist= new ArrayList<>();
        ResponseEntity<CoinBean> entity = restTemplate.getForEntity(apiURL, CoinBean.class);
        try {
            updateTime = CoinChangeUtil.parseUpdateTime(entity.getBody().getTime().getUpdated());
            coinlist = CoinChangeUtil.getDetails(entity.getBody().getBpi());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("dateTime", updateTime);
        model.addAttribute("coins", coinlist);

        return "coinapi";
    }


}
