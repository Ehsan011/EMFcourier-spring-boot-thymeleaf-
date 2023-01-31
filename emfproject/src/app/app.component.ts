import { Component, OnInit } from '@angular/core';
// import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'emfproject';

  // constructor(private tost: ToastrService){

  // }
ngOnInit(): void {
  // this.tost.success('Success', 'User Master');
  // this.tost.info("Info Success", "User Master");
  // this.tost.warning("Warning", "User Master");
  // this.tost.error("Error", "User Master");
  
}

}


