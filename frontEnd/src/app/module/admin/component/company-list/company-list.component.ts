import { Component, OnInit } from '@angular/core';

import {Company} from '../../../../model/company'
import {Router} from '@angular/router';
@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {
  companys:Company[] = [];
  constructor(private router:Router) { }
  ngOnInit(): void {
    this.companys.push({
      code:'123321',
      exchange:'BSE',
      name:'Sina',
      turnOver:'',
      ceo:'',
      sector:'',
      ipoDate:'',
      intro:''
    });
    this.companys.push({
      code:'234432',
      exchange:'nSE',
      name:'Tencent',
      turnOver:'',
      ceo:'',
      sector:'',
      ipoDate:'',
      intro:''
    });
  }

  newExchange(){
    this.router.navigate(['admin/addCompany']);
  }
}
