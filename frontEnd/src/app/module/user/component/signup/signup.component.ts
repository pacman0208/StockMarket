import { Component, OnInit } from '@angular/core';

import {RequestService} from '../../../../services/request.service';
import {UrlService} from '../../../../services/url.service';
import {CommonService} from '../../../../services/common.service';
import {Router} from '@angular/router';
interface User{
  username:string;
  password:string;
  phone:string;
  email:string;
}
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user:any={
    username:"",
    password:"",
    confirmPassword:"",
    mobileNumber:"",
    email:""
  };

  public msg:string = '';
  constructor(private reqSvc:RequestService,private urlSvc:UrlService,private common:CommonService,private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.user);
    var api:string = this.urlSvc.getUserURL();
    this.reqSvc.post(api,this.user).then((resp:any)=>{
      console.log(resp);
      if(resp.code=='200'){
        this.msg = 'Signup successfully!'
        this.router.navigate(['/login']);
      }else{
        this.msg = resp.msg;
      }
    });
  }
}
