import { Injectable } from '@angular/core';
import { stringify } from 'querystring';

@Injectable({
  providedIn: 'root'
})
export class MenuStoreageService {

  constructor() { }

  menuList:any[] = [];
  /*
  * generate menu list
  */
 public generateList(){
    console.log('generateList method called');
    this.menuList.push('IPO');
    this.menuList.push('Compare company/sector');
    this.menuList.push('Edit profile');
    this.menuList.push('Logout');
    // this.menuList.forEach(element => {
    //   this.set(element,element);
    // });
}

public getMenuList():any[]{
    console.log('getMenuList method called');
    console.log(this.menuList)
    return this.menuList;
}

public removeMenuList(){
    console.log('removeMenuList method called');
    this.menuList = [];
}
private set(key:string,value){
  localStorage.setItem(key, JSON.stringify(value));
}

private get(key:string){
  JSON.parse(localStorage.getItem(key));
}

private remove(key:string){
  localStorage.removeItem(key);
}
}
