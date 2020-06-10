package cn.com.sm.controller;

import cn.com.sm.service.SectorService;
import cn.com.sm.utils.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api/sector")
@RestController
//@CrossOrigin("${sm.frontend.url}") //This annotation is used for CORS for this controller
public class SectorController {
    @Resource
    private SectorService sectorService;

    @GetMapping
    public ResultBody getAllSectors(){
        return ResultBody.success(sectorService.listAllSectors());
    }
}
