package com.cath.cathdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCoin {

    private String name;
    private String nameTW;
    private float rate;

}
