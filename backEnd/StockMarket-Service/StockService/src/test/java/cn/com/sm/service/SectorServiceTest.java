package cn.com.sm.service;

import cn.com.sm.StockServiceApplication;
import cn.com.sm.entity.SectorsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest(classes = StockServiceApplication.class)
public class SectorServiceTest {

    @Resource
    private SectorService service;
    @Test
    public void saveTest(){
        SectorsEntity sector = new SectorsEntity();
        sector.setSectorName("NSY");
        sector.setCreateTsp(new Timestamp(new Date().getTime()));
        sector.setLastChgTsp(new Timestamp(new Date().getTime()));
        System.out.println(service.save(sector));
    }
}
