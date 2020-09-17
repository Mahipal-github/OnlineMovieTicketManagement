import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { NgForm } from '@angular/forms';
import { formArrayNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';

@Component({
  selector: 'app-search-shows',
  templateUrl: './search-shows.component.html',
  styleUrls: ['./search-shows.component.css']
})

export class SearchShowsComponent implements OnInit {

  screenname:String;
  movieid:number;
  moviedate:Date;

  show: any;

  toggleShowList;

  errorMsg=String;
  showError:boolean;

  constructor(private service: MovieService) { }

  ngOnInit() {
  }

  searchShow(form: NgForm){
   if(this.screenname!=null && this.movieid!=null && this.moviedate!=null){
      this.service.showsForScreenMovieDate(this.screenname,this.movieid,this.moviedate).subscribe(data=>this.show=data);
    }

    if(this.screenname!=null && this.movieid==null && this.moviedate==null){
      this.service.searchShowsScreenName(this.screenname).subscribe(data=>{this.show=data,this.toggleShowList=true},
        error=>{this.errorMsg=error.error.message, this.showError=true});
    }

    if(this.screenname!=null && this.movieid==null && this.moviedate!=null){
      this.service.showsForScreenDate(this.screenname,this.moviedate).subscribe(data=>{this.show=data,this.toggleShowList=true},
        error=>{this.errorMsg=error.error.message, this.showError=true}
        );
    }

    if(this.screenname==null && this.movieid!=null && this.moviedate!=null){
      this.service.showsForMovieDate(this.movieid,this.moviedate).subscribe(data=>this.show=data);
    }
    form.resetForm();
  }
}
