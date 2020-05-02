import { Component, OnInit } from '@angular/core';

import {AuthService} from "./service/auth.service";
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  loginUser:string;
  constructor(private authSvc:AuthService) { }

  ngOnInit(): void {
  }

  ngDoCheck(): void{
    console.log('login user:'+this.loginUser);
    this.loginUser = this.authSvc.getLoginUser();
  }
}
