import { Component, OnInit,Inject } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Sector } from 'src/app/model/sector';
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

  public msg:string;
  public exchanges:string[]=['NES','BES'];

  public sectors:Sector[]=[];

  BASE_URL:string='';//company base url
  S_BASE_URL:string='';//sector base url
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
  constructor(@Inject('SECTOR_BASE_URL') sbaseUrl,private router:ActivatedRoute,private r:Router, public http:HttpClient,private reqSvc:RequestService,private url:UrlService) {
    
  }

  ngOnInit(): void {
    this.router.params.subscribe((data)=>{
      
      var api = this.url.getCompanyURL()+"/"+data.id;
      this.reqSvc.get(api).then((resp:any)=>{
        
        console.log(resp);
        console.log(resp.code);
        this.company = resp.result;
      })
      // this.http.get(api).subscribe((response:any)=>{
      //   console.log(response);
      //   console.log(response.code);
      //   this.company = response.result;
      // });
    });
  }


  submitForm():void{
  }

}
