package cn.com.sm.service;

import cn.com.sm.entity.SectorsEntity;
import cn.com.sm.repo.SectorRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SectorServiceImpl implements SectorService {


    @Resource
    private SectorRepo sectorRepo;

    @Override
    public SectorsEntity save(SectorsEntity sector) {
        return sectorRepo.save(sector);
    }

    @Override
    public SectorsEntity getSectorById(Integer id) {
        return sectorRepo.getOne(id);
    }
}