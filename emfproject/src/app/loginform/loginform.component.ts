import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  form: FormGroup;
  isLoginFailed = false;
  errorMessage = ''
  constructor(private fb: FormBuilder, private router: Router, private http: HttpClient) {
    this.form = fb.group({
      email: ['', Validators.compose([Validators.required, Validators.email])],
      password: ['', Validators.required]

    });

  }

  ngOnInit(): void {
  }
  
  loginSave() {
    if (this.form.valid) {
      localStorage.setItem('isLoggedIn', 'true');
      this.checkLogin(this.form.value);
    }
    else {
      this.isLoginFailed = true;
      this.errorMessage = "[ Email and password are required. ]";
    }

  }

  checkLogin(data: any) {
    this.http.post('http://localhost:9001/user/login', data)
      .subscribe(
        {
          next: (res) => {
            this.router.navigate(['/user_details'])
          },
          error: (err) => {
            this.isLoginFailed = true;
            this.errorMessage = err.error.message;
          }
        }
      )
  }

}

