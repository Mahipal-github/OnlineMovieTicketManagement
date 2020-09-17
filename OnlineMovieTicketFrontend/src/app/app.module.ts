import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { SearchMovieComponent } from './search-movie/search-movie.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { SearchPageComponent } from './search-page/search-page.component';
import { SearchShowsComponent } from './search-shows/search-shows.component';
import { RecentMovieComponent } from './recent-movie/recent-movie.component';
import { MovieComponent } from './movie/movie.component';
import { DisplayShowsComponent } from './display-shows/display-shows.component';
import { DisplayScreensComponent } from './display-screens/display-screens.component';
import { BookMovieComponent } from './book-movie/book-movie.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { ErrorpagecomponentComponent } from './errorpagecomponent/errorpagecomponent.component';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';


/************************************************************************************************************************
 *          @author         Poojith, Mahipal, Arshad
 *          Description      App.module is responsible for Routing, and importing forms module, HttpClient  
 *         Version             1.0
 *         Created Date    12-Sep-2020
 ************************************************************************************************************************/


const appRoutes:Routes=[
{path:'',component:RecentMovieComponent},
{path:'displayshows/:movieId',component:DisplayShowsComponent},
{path:'displayscreens/:movieId',component:DisplayScreensComponent},
{path:'displayAllMovies', component: MovieComponent},
{path:'bookingDetails',component:BookingDetailsComponent},
{path:'book/:showId',component:BookMovieComponent},
{path:'searchMovie',component:SearchMovieComponent},
{path:'searchPage',component:SearchPageComponent},
{path:'searchShow',component:SearchShowsComponent},
{path:'cancelBooking/:bookingId',component:CancelBookingComponent},
{path:'home', component:HomeComponent},
{path:'contact', component:ContactUsComponent}, 
{path:'error',component:ErrorpagecomponentComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    SearchPageComponent,
    SearchMovieComponent,
    SearchShowsComponent,
    RecentMovieComponent,
    MovieComponent,
    DisplayShowsComponent,
    DisplayScreensComponent,
    BookMovieComponent,
    BookingDetailsComponent,
    CancelBookingComponent,
    ErrorpagecomponentComponent,
    HomeComponent,
    ContactUsComponent
    
  ],
  imports: [
    BrowserModule, 
    FormsModule, 
     HttpClientModule,
     RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
