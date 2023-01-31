import { Component } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Deliveryman } from 'src/app/model/deliveryman';
import { DeliverymanService } from 'src/app/services/deliveryman.service';

@Component({
  selector: 'app-deliveryman',
  templateUrl: './deliveryman.component.html',
  styleUrls: ['./deliveryman.component.css']
})

export class DeliverymanComponent implements OnInit{

  deliveryhero: Deliveryman=new Deliveryman();
  allhero: Deliveryman[]=[];
  submitted=false;

  constructor(
    private httpClient:HttpClient,
    private router:Router,
    private deliveryservice:DeliverymanService) { }

  ngOnInit(): void {
    this.deliveryhero=new Deliveryman();
    this.getAllHero();

  }

  getAllHero(){
    this.deliveryservice.getAllHero().subscribe(res=>{
      this.allhero=res;
    },err=>{
      alert("Unable to Delivery Hero");
    })
  }

  addHero(){
    this.submitted=true;
    this.deliveryservice.createHero(this.deliveryhero).subscribe(res=>{
      this.ngOnInit()
    },err=>{
      alert(err);
    })
  }

  editHero(){
    this.deliveryservice.updateHero(this.deliveryhero).subscribe( res=> {
      this.ngOnInit();
    }, err=>{
        alert("Failed to update data");
    })
  }

  deleteHero(heroId: Deliveryman){
    this.deliveryservice.deleteHero(heroId).subscribe(res=>{
      this.ngOnInit();
    }, err=>{
      alert("Failed to delete Data")
    }
    )
  }
}
