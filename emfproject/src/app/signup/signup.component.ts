import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  submitted = false;
  form: FormGroup;
  constructor(private fb: FormBuilder, private router: Router, private http: HttpClient) {
    this.form = fb.group({
      name: ['', Validators.required],
      email: ['', Validators.compose([Validators.required, Validators.email])],
      password: ['', Validators.required]

    });

  }
  get f() {
    return this.form.controls;
  }

  ngOnInit(): void {
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
}
