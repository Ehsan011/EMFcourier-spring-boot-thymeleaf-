import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {  UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-executive-office',
  templateUrl: './executive-office.component.html',
  styleUrls: ['./executive-office.component.css']
})
export class ExecutiveOfficeComponent implements OnInit{
  form: UntypedFormGroup;
  submitted = false;
  delivary_man: any = [];
  isEdit = false;
  
  constructor(private fb: UntypedFormBuilder, private http: HttpClient){
    
    this.form = fb.group({
      id: [],
       exeName: ['', Validators.required],
       exeCell: ['', ],
       exeEmail: ['', ],
       exePassword: ['', ],
       exeAddress: ['', ],
       exeCity: ['', ],
       empId: ['', ]
       
       
     });
  }

 ngOnInit(): void {
   
 }
 

}
