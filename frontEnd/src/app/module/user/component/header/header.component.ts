import { Component,OnInit } from '@angular/core';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public menuList:any[];

  constructor(private menuSvs:MenuStoreageService) { 
  }

  ngOnInit(): void {
    
  }

  ngDoCheck(): void{
    this.menuList = this.menuSvs.getMenuList();
  }
}
