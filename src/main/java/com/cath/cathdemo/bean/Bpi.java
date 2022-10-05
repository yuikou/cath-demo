package com.cath.cathdemo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bpi {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    private Float rate_float;
}
