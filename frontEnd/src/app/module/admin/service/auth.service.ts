import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  loginUser:string;

  setLoginUser(user:string){
    this.loginUser = user;
  }

  getLoginUser():any{
    return this.loginUser;
  }
}
