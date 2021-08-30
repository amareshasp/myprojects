import { Component, OnInit } from '@angular/core';
import { UserDataService } from '../../service/user-data.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  #panelOpenState = false;
  isLoggedIn: boolean = false;
  constructor(private userDataService: UserDataService) { }

  ngOnInit(): void {
    this.userDataService.cast.subscribe(data => this.isLoggedIn = data);
  }

}
