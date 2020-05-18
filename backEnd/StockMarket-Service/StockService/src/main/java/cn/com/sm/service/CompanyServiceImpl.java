package cn.com.sm.service;

import cn.com.sm.entity.CompanyEntity;
import cn.com.sm.repo.CompanyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyServiceImpl implements CompanyService{

    Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CompanyRepo companyRepo;

    @Override
    public CompanyEntity addCompany(CompanyEntity company) {
        LOG.info("addCompany method called...");
        return companyRepo.save(company);
    }

    @Override
    public CompanyEntity update(CompanyEntity company) {
        return companyRepo.saveAndFlush(company);
    }

    @Override
    public Iterable<CompanyEntity> listCompany() {
        return companyRepo.findAll();
    }

    @Override
    public CompanyEntity getCompanyById(int id) {
        return companyRepo.getOne(id);
    }
}
