import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';
import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
import {CommonService} from '../../../../services/common.service';

interface User{
  username:string;
  password:string;
  phone:string;
  email:string;
}
@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  public user:User={
    username:"",
    password:"",
    phone:"",
    email:""
  };
  constructor(private router:Router,private menuSvc:MenuStoreageService,private requestSvc:RequestService,private urlSvc:UrlService,private common:CommonService) { }

  ngOnInit(): void {
    
  }
  onSubmit(){
    console.log(this.user);
  }
}
