import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { CorporatesComponent } from './corporates/corporates.component';
import { HomeComponent } from './home/home.component';
import { UserhomeComponent } from './userhome/userhome.component';

const routes: Routes = [
  { path: 'about_emf', component: AboutComponent },
  { path: '', component: UserhomeComponent },
  { path: 'admin_home', component: HomeComponent },
  { path: 'corporates', component: CorporatesComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
