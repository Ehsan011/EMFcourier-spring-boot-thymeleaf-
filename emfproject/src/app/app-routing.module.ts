import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminComponent } from './admin/admin.component';
import { BookingInfoComponent } from './booking-info/booking-info.component';
import { CorporatesComponent } from './corporates/corporates.component';
import { DeliverymanComponent } from './deliveryman/deliveryman.component';
import { DriversComponent } from './drivers/drivers.component';
import { ExecutiveOfficeComponent } from './executive-office/executive-office.component';
import { HomeComponent } from './home/home.component';
import { UserhomeComponent } from './userhome/userhome.component';

const routes: Routes = [
  { path: 'about_emf', component: AboutComponent },
  { path: '', component: UserhomeComponent },
  { path: 'admin_home', component: HomeComponent },
  { path: 'corporates', component: CorporatesComponent },
  { path: 'admin_info', component: AdminComponent },
  { path: 'booking_info', component: BookingInfoComponent },
  { path: 'corporate_booking', component: CorporatesComponent },
  { path: 'delivery_man', component: DeliverymanComponent },
  { path: 'driver_info', component: DriversComponent },
  { path: 'executive', component: ExecutiveOfficeComponent },
  { path: 'sender_inf', component: CorporatesComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }