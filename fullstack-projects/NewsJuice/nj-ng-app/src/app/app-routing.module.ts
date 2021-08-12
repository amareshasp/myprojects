import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnalyticComponent } from './components/analytic/analytic.component';
import { NewsHomeComponent } from './components/newshome/newshome.component';
import { ProfileComponent } from './components/profile/profile.component';


const routes: Routes = [
  {path:'newshome', component: NewsHomeComponent},
  {path:'analytic', component: AnalyticComponent},
  {path:'profile', component : ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents  = [ NewsHomeComponent , ProfileComponent, AnalyticComponent]