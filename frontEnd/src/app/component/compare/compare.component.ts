import { Component, OnInit } from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.css']
})
export class CompareComponent implements OnInit {
  model: NgbDateStruct;

  public comList:string[] = ['Company','Sector'];

  public exchanges:string[]=['NSE','BSE'];

  constructor() { }

  ngOnInit(): void {
  }

  onCompare(){
    
  }
}
