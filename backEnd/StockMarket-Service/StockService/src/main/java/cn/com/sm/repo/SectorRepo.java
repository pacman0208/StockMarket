package cn.com.sm.repo;

import cn.com.sm.entity.SectorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepo extends JpaRepository<SectorsEntity,Integer> {
}
