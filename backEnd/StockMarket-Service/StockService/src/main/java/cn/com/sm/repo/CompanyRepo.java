package cn.com.sm.repo;

import cn.com.sm.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyEntity,Integer> {


}
