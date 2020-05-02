import { Component, OnInit } from '@angular/core';

import {MenuStoreageService} from '../../../../services/menu-storeage.service';
@Component({
  selector: 'app-left-menu',
  templateUrl: './left-menu.component.html',
  styleUrls: ['./left-menu.component.css']
})
export class LeftMenuComponent implements OnInit {
  menuList:any[];
  constructor(private menuSvs:MenuStoreageService) { }

  ngOnInit(): void {
  }

  ngDoCheck(): void{
    this.menuList = this.menuSvs.getLeftMenuList();
  }
}
