package com.cath.cathdemo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class CoinBean {

    private CoinTime time;
    private String disclaimer;
    private String chartName;
    private Map<String, Bpi> bpi;

}
