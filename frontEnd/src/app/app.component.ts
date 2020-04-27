import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontEnd';
  private router:Router;
  constructor(router:Router){
    
  }
  
  ngOnInit(): void {
    console.log(this.router);
  }
  
}
