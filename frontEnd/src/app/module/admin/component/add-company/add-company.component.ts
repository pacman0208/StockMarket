import { Component, OnInit, Inject } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Company } from 'src/app/model/company';
import {Router} from '@angular/router';
import { CompanyListComponent } from '../company-list/company-list.component';
import { Sector } from 'src/app/model/sector';

import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {

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
  constructor(@Inject('COMPANY_BASE_URL') baseUrl,@Inject('SECTOR_BASE_URL') sbaseUrl,private router:Router, public http:HttpClient,private reqSvc:RequestService,private url:UrlService) {
    this.BASE_URL = baseUrl;
    this.S_BASE_URL = sbaseUrl;
  }

  ngOnInit(): void {
    // var api = this.S_BASE_URL;
    var api = this.url.getSectorURL();

    this.reqSvc.get(api).then((resp:any)=>{
      if(resp.code=='200'){
        resp.result.forEach(e => {
          this.sectors.push(e);
        });
        console.log(JSON.stringify(this.sectors));
      }

    });
    // this.http.get(api).subscribe((resp:any)=>{
    //   if(resp.code=='200'){
    //     resp.result.forEach(e => {
    //       this.sectors.push(e);
    //     });
    //     console.log(JSON.stringify(this.sectors));
    //   }
    // });
  }

  submitForm():void{
    
    var api = this.url.getCompanyURL();
    this.reqSvc.post(api,this.company).then((resp:any)=>{
      console.log(resp);
      if(resp.code=='200'){
        this.router.navigate(['/admin/companyList']);
      }
      else{
        this.msg = resp.msg;
      }
    });
    // const httpOptions = {
    //   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    // };
    // var api = this.BASE_URL;
    // const data:string = JSON.stringify(this.company);
    // this.http.post(api,this.company,httpOptions).subscribe((resp:any)=>{
    //   console.log(resp.msg);
    //   if(resp.code=='200'){
    //     this.router.navigate(['/admin/companyList']);
    //   }
    //   if(resp.code=='500'){
    //     this.msg = resp.msg;
    //   }
    // });
  }
}
