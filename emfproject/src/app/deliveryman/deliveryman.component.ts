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
  submitted=false;

  constructor(private httpClient:HttpClient,private router:Router,
    private deliveryHero:Deliveryman) { }

  ngOnInit(): void {
  }

  

}
