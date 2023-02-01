import { Component } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Deliveryman } from 'src/app/model/deliveryman';
import { DeliverymanService } from 'src/app/services/deliveryman.service';
import {  UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-deliveryman',
  templateUrl: './deliveryman.component.html',
  styleUrls: ['./deliveryman.component.css']
})

export class DeliverymanComponent implements OnInit{

  form: UntypedFormGroup;
  submitted = false;
  user_details: any = [];
  isEdit = false;
  constructor(private fb: UntypedFormBuilder, private http: HttpClient) {
    this.form = fb.group({
     id: [],
      heroName: ['', Validators.required],
      heroCell: ['', ],
      heroEmail: ['', ],
      heroPassword: ['', ],
      heroAddress: ['', ],
      heroCity: ['', ],
      empId: ['', ]
      
      
    });
  }


  ngOnInit(): void {
    this.showAll();
  }
  get f() {
    return this.form.controls;
  }
  save(){
    this.submitted = true;
    if(this.form.valid){

      let url = 'http://localhost:9001/user/save/';
      let data = this.form.value;
      this.http.post(url, data).subscribe({
        next: response => {
          alert("Data was saved successful.")
        },
        error: err =>{
          alert("Data was saved failed!, Please try again.")

        }
      });
    }else{
      console.log("invalid");
    }
 }
 showAll(){
  let url = 'http://localhost:9001/user/getall';
  this.http.get(url).subscribe({
    next: response =>{
      this.user_details = response;
    },
    error: err =>{
      console.log(err);        
    }
  })
}
 
}
