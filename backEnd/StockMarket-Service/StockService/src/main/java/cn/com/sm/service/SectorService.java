package cn.com.sm.service;

import cn.com.sm.entity.SectorsEntity;

public interface SectorService {
    SectorsEntity save(SectorsEntity sector);

    SectorsEntity getSectorById(Integer id);

    Iterable<SectorsEntity> listAllSectors();

    void deleteById(Integer id);

    SectorsEntity update(SectorsEntity sector);
}
