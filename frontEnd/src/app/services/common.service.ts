import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  public token:string='';
  constructor() { }

  public setToken(token:string):void{
    this.token = token;
  }

  public getToken():string{
    return this.token;
  }
}
