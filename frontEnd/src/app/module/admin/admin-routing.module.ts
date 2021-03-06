import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './component/login/login.component';
import { AdminComponent } from './admin.component';
import { AddCompanyComponent } from './component/add-company/add-company.component';
import { ImportDataComponent } from './component/import-data/import-data.component';
import { ImportDataResultComponent } from './component/import-data-result/import-data-result.component';
import { LandingComponent } from './component/landing/landing.component';
import { CompanyListComponent } from './component/company-list/company-list.component';
import { ExchangeListComponent } from './component/exchange-list/exchange-list.component';
import { AddExchangeComponent } from './component/add-exchange/add-exchange.component';
import { CompanyDetailComponent } from './component/company-detail/company-detail.component';

const routes: Routes = [
  // {path:'addCompany',component:AddCompanyComponent},
  
  {
    path:'',
    component:AdminComponent,
    children:[
      {path:'login',component:LoginComponent},
      {path:'addCompany',component:AddCompanyComponent},
      {path:'importData',component:ImportDataComponent},
      {path:'landing',component:LandingComponent},
      {path:'companyList',component:CompanyListComponent},
      {path:'exchangeList',component:ExchangeListComponent},
      {path:'addExchange',component:AddExchangeComponent},
      {path:'exchangeList',component:ExchangeListComponent},
      {path:'importResult',component:ImportDataResultComponent},
      {path:'companyDetail/:id',component:CompanyDetailComponent}
    ]
  },
  {
    path:"**",
    redirectTo:'login'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
