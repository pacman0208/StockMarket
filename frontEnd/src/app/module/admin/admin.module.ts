import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { LoginComponent } from './component/login/login.component';
import { AddCompanyComponent } from './component/add-company/add-company.component';
import { ImportDataComponent } from './component/import-data/import-data.component';
import { ImportDataResultComponent } from './component/import-data-result/import-data-result.component';
import { LandingComponent } from './component/landing/landing.component';
import { CompanyListComponent } from './component/company-list/company-list.component';
import { ExchangeListComponent } from './component/exchange-list/exchange-list.component';
import { AddExchangeComponent } from './component/add-exchange/add-exchange.component';


@NgModule({
  declarations: [
    AdminComponent,
    LoginComponent, 
    AddCompanyComponent, 
    ImportDataComponent, 
    ImportDataResultComponent,
    LandingComponent,
    CompanyListComponent,
    ExchangeListComponent,
    AddExchangeComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
  ]
})
export class AdminModule { }
