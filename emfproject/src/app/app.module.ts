import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AboutComponent } from './about/about.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { CorporatesComponent } from './corporates/corporates.component';

import { DeliverymanComponent } from './deliveryman/deliveryman.component';
import { ExecutiveOfficeComponent } from './executive-office/executive-office.component';
import { AdminComponent } from './admin/admin.component';
import { BookingInfoComponent } from './booking-info/booking-info.component';
import { DriversComponent } from './drivers/drivers.component';
import { CorporatesBookingComponent } from './corporates-booking/corporates-booking.component';
import { SenderInfoComponent } from './sender-info/sender-info.component';
import { ReceiptInfoComponent } from './receipt-info/receipt-info.component';
import { ParcelDetailsComponent } from './parcel-details/parcel-details.component';
import { TrackingDetailsComponent } from './tracking-details/tracking-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    SidebarComponent,
    AboutComponent,
    UserhomeComponent,
    CorporatesComponent,
    DeliverymanComponent,
    ExecutiveOfficeComponent,
    AdminComponent,
    BookingInfoComponent,
    DriversComponent,
    CorporatesBookingComponent,
    SenderInfoComponent,
    ReceiptInfoComponent,
    ParcelDetailsComponent,
    TrackingDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
