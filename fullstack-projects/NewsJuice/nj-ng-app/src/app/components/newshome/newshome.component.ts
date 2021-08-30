import { Component, OnInit } from '@angular/core';
import { NewsDataService } from '../../service/news/news-data.service';
import { UserDataService } from '../../service/user-data.service';
@Component({
  selector: 'app-home',
  templateUrl: './newshome.component.html',
  styleUrls: ['./newshome.component.css']
})
export class NewsHomeComponent implements OnInit {

  newsData: any;
  isDataLoaded = false;
  isLoggedIn: boolean = false;
  constructor(private newsDataService: NewsDataService, public userDataService: UserDataService) {

  }

  ngOnInit(): void {

    console.log("Newshome", this.isLoggedIn);

    this.userDataService.cast.subscribe(data => this.isLoggedIn = data);

    this.newsDataService.getNews().subscribe(data => {
      this.newsData = data;
      this.isDataLoaded = true;
      console.log(this.newsData);
    });

  }

}
