import { Component, OnInit,Inject } from '@angular/core';

import {Company} from '../../../../model/company'
import {Router} from '@angular/router';

import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {
  companys:Company[] = [];
  BASE_URL:string='';
  constructor(@Inject('COMPANY_BASE_URL') baseUrl:string,private router:Router,public http:HttpClient) { 
    this.BASE_URL = baseUrl;
    
  }
  ngOnInit(): void {
    var api = this.BASE_URL+"/companyList";
    this.http.get(api).subscribe((response:any)=>{
      console.log(response);
      if(response.code=='200'){
        response.result.forEach(e => {
          this.companys.push(e);
          console.log(e);
        });
        
      }
    });
    // this.companys.push({
    //   code:'123321',
    //   exchange:'BSE',
    //   name:'Sina',
    //   turnOver:'',
    //   ceo:'',
    //   sector:'',
    //   ipoDate:'',
    //   intro:''
    // });
    // this.companys.push({
    //   code:'234432',
    //   exchange:'nSE',
    //   name:'Tencent',
    //   turnOver:'',
    //   ceo:'',
    //   sector:'',
    //   ipoDate:'',
    //   intro:''
    // });
  }

  newExchange(){
    this.router.navigate(['admin/addCompany']);
  }
}
