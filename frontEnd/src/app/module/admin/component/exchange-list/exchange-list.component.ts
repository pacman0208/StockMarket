import { Component, OnInit } from '@angular/core';
import {Exchange} from '../../../../model/exchange';
import {Router} from '@angular/router';

@Component({
  selector: 'app-exchange-list',
  templateUrl: './exchange-list.component.html',
  styleUrls: ['./exchange-list.component.css']
})
export class ExchangeListComponent implements OnInit {
  exchangeList:Exchange[] = [];
  constructor(private router:Router) { }

  newCompany(){
    this.router.navigate(['admin/addExchange']);
  }
  ngOnInit(): void {
    this.exchangeList.push({
      exchange:'NES',brief:'Test1',address:'Address 1',remark:'Test remark1'
    });
    this.exchangeList.push({
      exchange:'BES',brief:'Test2',address:'Address 2',remark:'Test remark2'
    });
  }

}
