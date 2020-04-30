import { Component, OnInit } from '@angular/core';

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
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(){
    console.log(this.user);
  }
}
