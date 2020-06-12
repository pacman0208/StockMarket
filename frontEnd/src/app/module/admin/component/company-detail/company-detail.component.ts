import { Component, OnInit,Inject } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Sector } from 'src/app/model/sector';
import { Company } from 'src/app/model/company';
import {Router,ActivatedRoute} from '@angular/router';
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
  constructor(@Inject('COMPANY_BASE_URL') baseUrl,@Inject('SECTOR_BASE_URL') sbaseUrl,private router:ActivatedRoute, public http:HttpClient) {
    this.BASE_URL = baseUrl;
  }

  ngOnInit(): void {
    this.router.params.subscribe((data)=>{
      
      var api = this.BASE_URL+"/"+data.id;
      this.http.get(api).subscribe((response:any)=>{
        console.log(response);
        console.log(response.code);
        this.company = response.result;
      });
    });
  }


  submitForm():void{}

}
