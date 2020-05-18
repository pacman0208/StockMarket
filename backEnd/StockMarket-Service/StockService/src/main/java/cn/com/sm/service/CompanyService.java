package cn.com.sm.service;

import cn.com.sm.entity.CompanyEntity;

public interface CompanyService {
    CompanyEntity addCompany(CompanyEntity company);

    CompanyEntity update(CompanyEntity company);

    Iterable<CompanyEntity> listCompany();

    CompanyEntity getCompanyById(int id);
}
