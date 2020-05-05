import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {

  exchanges:string[]=['NES','BES'];
  constructor() { }

  ngOnInit(): void {
  }

}
