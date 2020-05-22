package cn.com.sm.service;

import cn.com.sm.StockServiceApplication;
import cn.com.sm.entity.CompanyEntity;
import cn.com.sm.entity.SectorsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest(classes = StockServiceApplication.class)
public class CompanyServiceTest {
    @Resource
    private CompanyService cService;

    @Resource
    private SectorService sService;

    @Transactional
    @Test
    public void addCompanyTest() {
        CompanyEntity company = new CompanyEntity();
        SectorsEntity sectorById = sService.getSectorById(1);
        System.out.println("sector:"+sectorById);
        company.setSectorsBySectorsId(sectorById);
        company.setCeo("Lee");
        company.setBoardOfDirectors("test");
        company.setCompanyName("Netease");
        company.setStockCode("23456");
        company.setTurnover(2.01);
        company.setListInExchanges("1");
        company.setBriefIntro("A China mulitiple internet company");
        System.out.println(cService.addCompany(company));
    }

    @Transactional
    @Test
    /**
     * add @Transaction here to avoid hibernate lazy load issue
     */
    public void getCompanyByIdTest(){
        System.out.println(cService.getCompanyById(1));
    }

    @Test
    public void listCompanyTest(){
        cService.listCompanys().forEach(System.out::println);
    }


}
