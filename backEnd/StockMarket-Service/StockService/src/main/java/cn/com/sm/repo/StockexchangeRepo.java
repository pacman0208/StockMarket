package cn.com.sm.repo;

import cn.com.sm.entity.StockexchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockexchangeRepo extends JpaRepository<StockexchangeEntity,Integer> {
}
