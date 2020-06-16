import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  public USER_URL:string = '/api/user';

  public COMPANY_URL:string = '/api/company';

  public SECTOR_URL:string = "/api/sector"
  public BASE_URL:String = 'http://localhost:9999'
  constructor() { }

  public getUserURL():string{
    return this.BASE_URL+this.USER_URL;
  }

  public getCompanyURL():string{
    return this.BASE_URL+this.COMPANY_URL;
  }

  public getSectorURL():string{
    return this.getCompanyURL()+this.SECTOR_URL;
  }
}
