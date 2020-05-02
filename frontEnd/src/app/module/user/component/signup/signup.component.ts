import { Component, OnInit } from '@angular/core';

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

  public user:User={
    username:"",
    password:"",
    phone:"",
    email:""
  };
  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.user);
  }
}
