import { Component } from '@angular/core';
import { Login } from './login';
import { MovieService } from './movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MovieTicket';
  login:Login=new Login();
  token:string=localStorage.getItem("token");
  msg:string;
  errorMsg:string;
  loginFlag:boolean=true;
  showLoginFlag:boolean=true;
  showNavFlag: boolean;
  modalflag:boolean=false;


  constructor(private diagnosisService:MovieService,private router:Router){
  }

  showLogin(){
    this.showLoginFlag=true;
    this.modalflag=true;
  }
     

  doLogin(){
   this.diagnosisService.dologin(this.login.uname,this.login.pwd).subscribe(data=>{localStorage.setItem("token",data);
      let arr=data.split("-");
      this.token=localStorage.getItem("token");
      this.diagnosisService.userName=this.diagnosisService.decrypt(arr[1]);
      this.showLoginFlag=false;
      this.showNavFlag=true;
      this.modalflag=false;
    },
    error=>{console.log(error);
    this.errorMsg=JSON.parse(error.error).message}); 
    this.router.navigateByUrl("/home");
    this.loginFlag=false;

  }
  doLogOut(){
    this.diagnosisService.dologout().subscribe(data=>{console.log(data);
      localStorage.removeItem("token");
      alert("You have logged out");
      this.token=undefined;
      });
    alert("You have logged out");
    this.login.pwd="";
    this.showLoginFlag=true;
    this.loginFlag=true;
  }


}
