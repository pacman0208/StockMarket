import { Component, OnInit,Inject } from '@angular/core';

import {Company} from '../../../../model/company'
import {Router} from '@angular/router';

import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
import {HttpClient,HttpHeaders} from '@angular/common/http';
@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {
  companys:Company[] = [];
  BASE_URL:string='';
  constructor(@Inject('COMPANY_BASE_URL') baseUrl:string,private router:Router,public http:HttpClient,private reqSvc:RequestService,private url:UrlService) { 
    this.BASE_URL = baseUrl;
    
  }
  ngOnInit(): void {
    var api = this.url.getCompanyURL()+"/companyList";
    
    this.reqSvc.get(api).then((response:any)=>{
      console.log(response);
      if(response.code=='200'){
        response.result.forEach(e => {
          this.companys.push(e);
          console.log(e);
        });
        
      }
    });
    

  }

  /**
   * delete method
   */
  onDelete(id:string){
    var api = this.BASE_URL+"/"+id;
    if(confirm("Do you want to delete this company?")){
      this.reqSvc.delete(api).then((resp:any)=>{
        console.log(resp);
        if(resp.code=='200'){
          window.location.reload();
        }
      });
      // this.http.delete(api).subscribe((response:any)=>{
      //   console.log(response);
      //   if(response.code=='200'){
      //     window.location.reload();
      //   }
      // });
    }else{
      alert("quit delete!");
    }
    
  }




  newExchange(){
    this.router.navigate(['admin/addCompany']);
  }
}
