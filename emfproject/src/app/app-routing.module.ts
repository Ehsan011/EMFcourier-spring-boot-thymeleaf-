import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminComponent } from './admin/admin.component';
import { BookingInfoComponent } from './booking-info/booking-info.component';
import { BookingStatusComponent } from './booking-status/booking-status.component';
import { CorporatesComponent } from './corporates/corporates.component';
import { DeliverymanComponent } from './deliveryman/deliveryman.component';
import { DriversComponent } from './drivers/drivers.component';
import { ExecutiveOfficeComponent } from './executive-office/executive-office.component';
import { HomeComponent } from './home/home.component';
import { LoginformComponent } from './loginform/loginform.component';
import { ParcelDetailsComponent } from './parcel-details/parcel-details.component';
import { ProfileComponent } from './profile/profile.component';
import { ReceiptInfoComponent } from './receipt-info/receipt-info.component';
import { SenderInfoComponent } from './sender-info/sender-info.component';
import { AuthGuard } from './services/auth.guard';
import { SignupComponent } from './signup/signup.component';
import { TrackingDetailsComponent } from './tracking-details/tracking-details.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserhomeComponent } from './userhome/userhome.component';

const routes: Routes = [
  // {path : '' , component : LoginformComponent },
  { path: 'about_emf' , component: AboutComponent },
  { path: '', component: UserhomeComponent },
  { path: 'admin_home' , component: HomeComponent },
  { path: 'corporates' , component: CorporatesComponent },
  { path: 'admin_info' , component: AdminComponent },
  { path: 'booking_info' , component: BookingInfoComponent },
  { path: 'corporate_booking' , component: CorporatesComponent },
  { path: 'delivery_man' , component: DeliverymanComponent },
  { path: 'driver_info', component: DriversComponent },
  { path: 'executive' , component: ExecutiveOfficeComponent },
  { path: 'sender_info' , component: SenderInfoComponent },
  { path: 'receipt_info' , component: ReceiptInfoComponent },
  { path: 'parcel_detalis' , component: ParcelDetailsComponent },
  { path: 'tracking_system' , component: TrackingDetailsComponent },
  { path: 'user_details' , component: UserDetailsComponent ,canActivate:[AuthGuard]},
  { path: 'booking_status' , component: BookingStatusComponent },
  {path : 'loginform' , component : LoginformComponent },
  {path : 'signup', component: SignupComponent},
  {path : 'profile', component: ProfileComponent, canActivate:[AuthGuard]}
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
