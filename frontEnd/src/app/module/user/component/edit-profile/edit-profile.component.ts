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
  public msg:string = '';

  public user:any={
    username:"",
    password:"",
    mobileNumber:"",
    email:""
  };
  constructor(private router:Router,private menuSvc:MenuStoreageService,private requestSvc:RequestService,private urlSvc:UrlService,private common:CommonService) { }

  ngOnInit(): void {
    const api = this.urlSvc.getUserURL();
    this.requestSvc.get(api).then((resp:any)=>{
      console.log(resp);
      if(resp.code=='200'){
        this.user = resp.result;
      }
      
    });
  }
  onSubmit(){
    console.log(this.user);
    const api = this.urlSvc.getUserURL();
    this.requestSvc.put(api,this.user).then((resp:any)=>{
      
      console.log(resp);
      if(resp.code=='200'){
        this.user = resp.result;
        this.msg='update successfully!';
      }
    });
  }
}
