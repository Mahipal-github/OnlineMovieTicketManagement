import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ThrowStmt } from '@angular/compiler';
import { MovieConstantsService } from './movie-constants.service';
import { BookingForm } from './Model/BookingForm';

@Injectable({
  providedIn: 'root'
})

/*************************************************************************************************************************
 *          @author         Poojith, Mahipal, Arshad
 *          Description      This is a angular service file.
 *         Version             3.0
 *         Created Date      10-Sep-2020
 *************************************************************************************************************************/
export class MovieService {
  userName: string;

  constructor(private http: HttpClient) { 
  }
  
  public searchMovie(name: String) : Observable<any>{
    return this.http.get(MovieConstantsService.searchMovieUrl+name) ;
  }

  public searchShowsScreenName(screenName: String){
    return this.http.get(MovieConstantsService.searchShowsForScreen+screenName);
  }

  public showsForScreenMovieDate(screenName: String, movieId: number, movieDate:Date){
    return this.http.get(MovieConstantsService.searchShowsScreenMovieDate+screenName+"/"+movieId+"/"+movieDate);
  }

  public showsForScreenDate(screenName:String, movieDate:Date){
    return this.http.get(MovieConstantsService.searchShowsScreenDate+screenName+"/"+movieDate);
  }

  public showsForMovieDate(movieId:number, movieDate:Date){
    return this.http.get(MovieConstantsService.searchShowsMovieDate+movieId+"/"+movieDate);
  }



  public viewmovies(){
    return this.http.get(MovieConstantsService.viewmovies);
  }

  public viewnewmovies(){
    return this.http.get(MovieConstantsService.viewnewmovies);
  }


  public displayshows(movieId: number){
    return this.http.get(MovieConstantsService.viewshows+movieId);
  }

  public displayscreens(movieId: number){
    return this.http.get(MovieConstantsService.viewscreens+movieId);
  }


  public bookmovie(form: BookingForm){
    return this.http.post(MovieConstantsService.bookmovie,form);
  }

  public cancelbooking(bookingId: String){
    return this.http.get(MovieConstantsService.cancelbooking+bookingId);
  }


  public searchDetails(contact:String) : Observable<any>
  {
    return this.http.get(MovieConstantsService.searchBookingDetails+contact);
  }

  
  decrypt(token : string){
    let str = " ";
    for ( let i = 0 ; i < token.length ; ++i){
      str = str + String.fromCharCode(token.charCodeAt(i) - 3)
    }
    console.log(str);
    return str;
  }
  public dologin(userId:string, password:string):Observable<any>{

    let postData = new FormData(); 
    postData.append('userId' , userId); 
    postData.append('password', password);
 return this.http.post("http://localhost:8082/onlineMovie/login",postData, {responseType: 'text'});
 }
 
 public dologout(){
 let utoken = localStorage.getItem("token");
  if(utoken == null) utoken=""; 
  const httpHeaders = new HttpHeaders({"userId": utoken});
   return this.http.get("http://localhost:8082/onlineMovie/logout", {headers:httpHeaders, responseType: 'text'});
 }

}
