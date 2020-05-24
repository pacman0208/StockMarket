package cn.com.sm.service;

import cn.com.sm.entity.StockexchangeEntity;
import cn.com.sm.repo.StockexchangeRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class StockExServiceImpl implements StockExService{

    @Resource
    private StockexchangeRepo repo;
    @Override
    public StockexchangeEntity add(StockexchangeEntity stockEx) {
        return repo.save(stockEx);
    }

    @Override
    public StockexchangeEntity update(StockexchangeEntity stockEx) {
        return repo.saveAndFlush(stockEx);
    }

    @Override
    public Iterable<StockexchangeEntity> listStockEx() {
        return repo.findAll();
    }

    @Override
    public StockexchangeEntity getStockExById(Integer id) {
        Optional<StockexchangeEntity> optional = repo.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return new StockexchangeEntity();
    }
}
