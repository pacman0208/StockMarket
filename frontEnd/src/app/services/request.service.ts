import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {UrlService} from './url.service';
import {CommonService} from './common.service';
import { resolve } from 'dns';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http:HttpClient,private url:UrlService,private common:CommonService) { }

  get(api:string){
      var token = this.common.getToken();
      
    const headers = {
      headers: new HttpHeaders({ 'Authorization': token })
    }
      return new Promise((resolve,reject)=>{
        this.http.get(api,headers).subscribe(response=>{
            resolve(response);
        });
      });
  }

  put(api:string,obj:any){
    var token = this.common.getToken();
    const httpOptions = {
      headers: new HttpHeaders().set('Content-Type','application/json').set('Authorization', token)
    };
    return new Promise((resolve,reject)=>{
        this.http.post(api,obj,httpOptions).subscribe((response)=>{
          resolve(response);
        });
    });
  }

  post(api:string,obj:any){
    var token = this.common.getToken();
    const httpOptions = {
      headers: new HttpHeaders().set('Content-Type','application/json').set('Authorization', token)
    };
    return new Promise((resolve,reject)=>{
        this.http.post(api,obj,httpOptions).subscribe((response)=>{
          resolve(response);
        });
    });
  }
}
