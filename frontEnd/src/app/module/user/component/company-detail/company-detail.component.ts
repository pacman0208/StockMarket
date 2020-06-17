import { Component, OnInit } from '@angular/core';

import { Company } from 'src/app/model/company';
import {Router,ActivatedRoute} from '@angular/router';


import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
@Component({
  selector: 'app-company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.css']
})
export class CompanyDetailComponent implements OnInit {
  public company:Company={
    id:'',
    companyName:'',
    stockCode:'',
    turnover:'',
    ceo:'',
    //ipoDate:string;
    exchangeName:'',
    briefIntro:'',
    sectorsBySectorsId:{
        id:'',
        sectorName:''
    }
  };
  constructor(private router:ActivatedRoute,private r:Router,private reqSvc:RequestService,private url:UrlService) { }

  ngOnInit(): void {
    
    this.router.params.subscribe((data)=>{
      
      var api = this.url.getCompanyURL()+"/"+data.id;
      this.reqSvc.get(api).then((resp:any)=>{
        
        console.log(resp);
        console.log(resp.code);
        this.company = resp.result;
      })
      
    });
  }

  back(){
    this.r.navigate(['/user/ipo']);
  }
}
