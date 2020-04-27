import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  head:string = 'Please sign in';

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  login():void{

  }

  toSignup():void{
    this.router.navigate(['/signup']);
  }
}
