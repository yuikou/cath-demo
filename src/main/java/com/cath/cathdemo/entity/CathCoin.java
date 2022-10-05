package com.cath.cathdemo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="CATHCOIN")
@Data
public class CathCoin {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "code")
    private String coinName;

    @Column(name = "code_tw")
    private String coinNameTw;

}
