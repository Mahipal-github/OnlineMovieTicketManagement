import { Component, OnInit } from '@angular/core';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
/*************************************************************************************************************************
 *          @author          Poojith, Mahipal, Arshad
 *         Version             1.0
 *         Created Date    10-Sep-2020
 *************************************************************************************************************************/
export class SearchPageComponent implements OnInit {
  constructor() { }
  title="Please search your required movie!"

  ngOnInit() {
  }
}
