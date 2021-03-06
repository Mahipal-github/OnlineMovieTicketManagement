import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MovieService } from '../movie.service';
import { combineLatest } from 'rxjs';

@Component({
  selector: 'app-search-movie',
  templateUrl: './search-movie.component.html',
  styleUrls: ['./search-movie.component.css']
})
export class SearchMovieComponent implements OnInit {


  movieList:any ;
  name:string;
  toggleMovieList:boolean =false;

  errorMsg=String;
  showError:boolean;

  constructor(private movieService :MovieService) {
  }

  ngOnInit() {
 }

  searchMovie(form: NgForm){
   this.movieService.searchMovie(this.name).subscribe(
     data=>{this.movieList=data,this.toggleMovieList=true},
     error=>{this.errorMsg=error.error.message,this.showError=true}     );
   form.resetForm();
  }

}
