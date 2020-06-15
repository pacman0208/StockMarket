import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {UrlService} from './url.service'
import { resolve } from 'dns';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http:HttpClient,private url:UrlService) { }

  get(api:string){
      return new Promise((resolve,reject)=>{
        this.http.get(api).subscribe(response=>{
            resolve(response);
        });
      });
  }

  post(api:string,obj:any){
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return new Promise((resolve,reject)=>{
        this.http.post(api,obj,httpOptions).subscribe((response)=>{
          resolve(response);
        });
    });
  }
}
