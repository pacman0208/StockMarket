import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  public USER_URL:string = 'http://localhost:8881';
  constructor() { }
}
