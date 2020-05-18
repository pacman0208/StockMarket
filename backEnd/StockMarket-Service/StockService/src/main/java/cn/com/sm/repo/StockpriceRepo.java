package cn.com.sm.repo;

import cn.com.sm.entity.StockpriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockpriceRepo extends JpaRepository<StockpriceEntity,Integer> {
}
