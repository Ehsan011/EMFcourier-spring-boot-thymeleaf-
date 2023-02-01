import { Component, OnInit } from '@angular/core';
import {  UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  
  form: UntypedFormGroup;
  submitted = false;
  user_details: any = [];
  isEdit = false;
  constructor(private fb: UntypedFormBuilder, private http: HttpClient) {
    this.form = fb.group({
      id: [],
      senderName: ['', Validators.required],
      senderMobileNo: ['', ],
      district: ['Select', ],
      nearestArea: ['Select', ],
      senderAddress: ['', ],
      postalCode: ['', ],
      recipientName: ['', ],
      recipientMobileNo: ['', ],
      recipientAddress: ['', ],
      instruction: ['', ],
      selectProductType: ['Document', ],
      packageWeight: ['Select Weight', ],
      numberOfItem: ['', ],
      payment: ['', ]
      
      
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

      let url = 'http://localhost:9001/userd/save/';
      let data = this.form.value;
      this.http.post(url, data).subscribe({
        next: response => {
          alert("Data was saved successful.")
          this.showAll();
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
  let url = 'http://localhost:9001/userd/getall';
  this.http.get(url).subscribe({
    next: response =>{
      this.user_details = response;
    },
    error: err =>{
      console.log(err);        
    }
  })
}
edit(UserDetails: any){
  this.form.setValue({
    
    id: UserDetails.id,
    senderName: UserDetails.senderName,
    senderMobileNo: UserDetails.senderMobileNo,
    district: UserDetails.district,
    nearestArea: UserDetails.nearestArea,
    senderAddress: UserDetails.senderAddress,
    postalCode: UserDetails.postalCode,
    recipientName: UserDetails.recipientName,
    recipientMobileNo: UserDetails.recipientMobileNo,
    recipientAddress: UserDetails.recipientAddress,
    instruction: UserDetails.instruction,
    selectProductType: UserDetails.selectProductType,
    packageWeight: UserDetails.packageWeight,
    numberOfItem: UserDetails.numberOfItem,
    payment: UserDetails.payment    

  });
  this.isEdit = true;
}
deleteById(id: number){
  let url = 'http://localhost:9001/userd/delete/'+id;
  this.http.get(url).subscribe({
    next: response =>{
      alert("Recored was deleted.");
      this.showAll();
    },
    error: err =>{
      alert("Recored deletation failed!.");
    }
  })
}


        relode(){
          window.location.reload();
        }



}
