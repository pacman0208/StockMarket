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

  }

  /**
   * delete method
   */
  onDelete(id:string){
    var api = this.BASE_URL+"/"+id;
    if(confirm("Do you want to delete this company?")){
      this.http.delete(api).subscribe((response:any)=>{
        console.log(response);
        if(response.code=='200'){
          window.location.reload();
        }
      });
    }else{
      alert("quit delete!");
    }
    
  }




  newExchange(){
    this.router.navigate(['admin/addCompany']);
  }
}
