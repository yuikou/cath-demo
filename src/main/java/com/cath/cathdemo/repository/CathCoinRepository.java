package com.cath.cathdemo.repository;

import com.cath.cathdemo.entity.CathCoin;
import org.springframework.data.jpa.repository.JpaRepository;

//繼承JpaRepository來完成對資料庫的操作
public interface CathCoinRepository extends JpaRepository<CathCoin, String> {
}
