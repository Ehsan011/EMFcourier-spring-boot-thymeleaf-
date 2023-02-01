import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-booking-status',
  templateUrl: './booking-status.component.html',
  styleUrls: ['./booking-status.component.css']
})
export class BookingStatusComponent implements OnInit {
  
  form: UntypedFormGroup;
  submitted = false;
  status: any = [];
  isEdit = false;
  constructor(private fb: UntypedFormBuilder, private http: HttpClient
    ) {
    this.form = fb.group({
      id: [],
      status: ['', Validators.required],
      place: ['', ],
     
      
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

      let url = 'http://localhost:9001/status/save/';
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
  let url = 'http://localhost:9001/status/getall';
  this.http.get(url).subscribe({
    next: response =>{
      this.status = response;
    },
    error: err =>{
      console.log(err);        
    }
  })
}
edit(Status: any){
  this.form.setValue({
    
    id: Status.id,
    status: Status.status,
   
    place: Status.place
     

  });
  this.isEdit = true;
}
deleteById(id: number){
  let url = 'http://localhost:9001/status/delete/'+id;
  this.http.get(url).subscribe({
    next: response =>{
      alert("Recored was deleted.");
    },
    error: err =>{
      alert("Recored deletation failed!.");
    }
  })
}


}

