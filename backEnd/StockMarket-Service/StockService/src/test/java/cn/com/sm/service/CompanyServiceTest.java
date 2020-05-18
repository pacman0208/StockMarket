package cn.com.sm.service;

import cn.com.sm.StockServiceApplication;
import cn.com.sm.entity.CompanyEntity;
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
    @Test
    public void addCompanyTest() {
        CompanyEntity company = new CompanyEntity();
        company.setSectorsBySectorsId(sService.getSectorById(1));
        company.setCeo("Lee");
        company.setBoardOfDirectors("test");
        company.setCompanyName("Netease");
        company.setStockCode("23456");
        company.setTurnover(2.01);
        company.setListInExchanges("1");
        company.setBriefIntro("A China mulitiple internet company");
        cService.addCompany(company);
    }

    @Transactional
    @Test
    public void getCompanyByIdTest(){
        System.out.println(cService.getCompanyById(1));
    }

    @Test
    public void listCompanyTest(){
        cService.listCompany().forEach(System.out::println);
    }
}
