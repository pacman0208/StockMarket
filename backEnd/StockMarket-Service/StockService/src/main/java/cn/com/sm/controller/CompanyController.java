package cn.com.sm.controller;

import cn.com.sm.entity.CompanyEntity;
import cn.com.sm.service.CompanyService;
import cn.com.sm.util.ResultBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/company")
//@CrossOrigin("${sm.frontend.url}") //This annotation is used for CORS for this controller
public class CompanyController {

    @Resource
    private CompanyService companyService;
    @GetMapping("exp")
    public void expTest() throws Exception {
        throw new Exception("internal exception");
    }

    @GetMapping("/companyList")
    public ResultBody listAllCompanys(){
        return ResultBody.success(companyService.listCompanys());
    }

    @GetMapping("/{id}")
    public ResultBody companyDetail(@PathVariable Integer id){
        System.out.println("ip:"+ip+",port:"+port);
        return ResultBody.success(companyService.getCompanyById(id));
    }

    @PostMapping
    public ResultBody addCompany(@RequestBody  CompanyEntity company){
        System.out.println("Got from frontend:"+company);
        return ResultBody.success(companyService.addCompany(company));
    }

    @DeleteMapping("/{id}")
    public ResultBody deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return ResultBody.success();
    }

    @Value("${server.port}")
    /**
     * add this attribute to enable ribbon found service by service name
     */
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    /**
     * add this attribute to enable ribbon found service by service name
     */
    private String ip;
}
