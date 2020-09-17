import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  msg:string;
  errorMsg:string;

  customer_id:string;
  userName:string;
  role:string;

  userFlag:boolean=true;
  adminFlag:boolean=true;

  constructor(private diagnosisService:MovieService) { }

  ngOnInit() {
    //let token = localStorage.getItem('token');
    //if(token != null){
   //   this.customer_id= this.service.decrypt(token.split('-')[0]);
   //   this.userName= this.service.decrypt(token.split('-')[1]);
  //    this.role=this.service.decrypt(token.split('-')[2]);
   //   if(role.trim()== "admin"){
 //       this.adminFlag=true;
   //     this.userFlag=true;
 //     }
 //     else{
//        this.adminFlag=true;
 //       this.userFlag=true;
 //     }
 //   }
  }





  

}
