package cn.com.sm.service;

import cn.com.sm.StockServiceApplication;
import cn.com.sm.entity.SectorsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest(classes = StockServiceApplication.class)
public class SectorServiceTest {

    @Resource
    private SectorService service;
    @Test
    public void saveTest(){
        SectorsEntity sector = new SectorsEntity();
        sector.setSectorName("BSE");
        System.out.println(service.save(sector));
    }

    @Test
    @Transactional//make sure different service and share the DB session
    @Rollback(false)//not roll back for this transaction
    public void updateTest(){
        SectorsEntity sector = service.getSectorById(1);
        sector.setLastChgTsp(null);//set null to make @LastModifiedDate effect
        sector.setSectorName("NSE");
        System.out.println(service.update(sector));
    }
    @Test
    public void deleteTest(){
        service.deleteById(2);
    }

    @Test
    public void listAllSectorsTest(){
        service.listAllSectors().forEach(System.out::println);
    }
}
