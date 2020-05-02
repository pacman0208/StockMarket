//router configuration
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  //lazy load router
  {
    path:"admin",
    loadChildren: () => import('./module/admin/admin.module').then(mod => mod.AdminModule)
  },
  {
    path:"user",
    loadChildren: () => import('./module/user/user.module').then(mod => mod.UserModule)
  },
  //if there's no path match, then redirect to this path
   {path:"**",redirectTo:"user/login"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
