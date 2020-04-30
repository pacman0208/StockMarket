import { Injectable } from '@angular/core';
import { stringify } from 'querystring';

@Injectable({
  providedIn: 'root'
})
export class MenuStoreageService {

  constructor() { }

  menuList:any[] = [{}];
  /*
  * generate menu list
  */
 public generateList(){
    console.log('generateList method called');
    this.menuList.push({name:'Home',url:'userlanding'});
    this.menuList.push({name:'IPO',url:'ipo'});
    this.menuList.push({name:'Compare company/sector',url:'compare'});
    this.menuList.push({name:'Edit profile',url:'edit-profile'});
    this.menuList.push({name:'Logout',url:'login'});
    // this.menuList.forEach(element => {
    //   this.set(element,element);
    // });
}

public getMenuList():any[]{
    //console.log('getMenuList method called');
    //console.log(this.menuList)
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
