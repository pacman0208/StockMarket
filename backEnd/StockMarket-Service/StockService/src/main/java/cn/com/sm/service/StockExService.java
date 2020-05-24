package cn.com.sm.service;

import cn.com.sm.entity.StockexchangeEntity;

public interface StockExService {
    StockexchangeEntity add(StockexchangeEntity stockEx);

    StockexchangeEntity update(StockexchangeEntity stockEx);

    Iterable<StockexchangeEntity> listStockEx();

    StockexchangeEntity getStockExById(Integer id);
}
