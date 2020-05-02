import { Component, OnInit } from '@angular/core';

interface Company{
  name:string;
  exchange:string;
  address:string;
}
@Component({
  selector: 'app-ipo',
  templateUrl: './ipo.component.html',
  styleUrls: ['./ipo.component.css']
})
export class IpoComponent implements OnInit {

  public companys:Company[]=[];

  public exchanges:string[]=[];

  exchangeSel:string;

  constructor() {
   }

  ngOnInit(): void {
    this.initData();
  }

  switchExchange(){
    console.log(this.exchangeSel);
  }
  /**
   * initial page data
   */
  initData(){
    this.companys.push({
      name:'Sina',
      exchange:'BSE',
      address:'BeiJing Wang Fu street #321'
    });
    this.companys.push({
      name:'Alibaba',
      exchange:'NSE',
      address:'Hang Zhou City XiHu Street #998'
    });
    this.companys.push({
      name:'Tencent',
      exchange:'NSE',
      address:'ShenZhen City FuQiang Road #1314'
    });
    this.exchanges.push("NSE");
    this.exchanges.push("BSE");
  }
}
