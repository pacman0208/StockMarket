import { Injectable } from '@angular/core';
import { stringify } from 'querystring';

@Injectable({
  providedIn: 'root'
})
export class MenuStoreageService {

  constructor() { }

  menuList:any[] = [{}];

  leftMenuList:any[]=[{}];
  /*
  * generate menu list(for user page)
  */
 public generateList(){
    console.log('generateList method called');
    this.menuList.push({name:'Home',url:'user/userlanding'});
    this.menuList.push({name:'IPO',url:'user/ipo'});
    this.menuList.push({name:'Compare company/sector',url:'user/compare'});
    this.menuList.push({name:'Edit profile',url:'user/edit-profile'});
    this.menuList.push({name:'Logout',url:'user/login'});
    // this.menuList.forEach(element => {
    //   this.set(element,element);
    // });
}

/**
 * for user page
 */
public removeMenuList(){
  console.log('removeMenuList method called');
  this.menuList = [];
}

/**
 * for user page
 */
public getMenuList():any[]{
  return this.menuList;
}
/**
 * for admin page
 */
public generateLeftMenu(){
  
  console.log('generateLeftMenu method called');
  this.leftMenuList.push({name:'Manage Stock Exchanges',url:'admin/exchangeList'});
  this.leftMenuList.push({name:'Mange Company',url:'admin/companyList'});
  this.leftMenuList.push({name:'Import Data',url:'admin/importData'});
  this.leftMenuList.push({name:'Logout',url:'admin/login'});
}
/**
 * for admin page
 */
public removeLeftMenuList(){
  this.leftMenuList = [];
}

/**
 * for admin page
 */
public getLeftMenuList():any[]{
  return this.leftMenuList;
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
