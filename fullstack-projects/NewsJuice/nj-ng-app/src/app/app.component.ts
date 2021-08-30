import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserDataService } from './service/user-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'nj-ng-app';
  navLinks: any[];
  activeLinkIndex = -1;


  loginDialog = false;
  userName: string = "";
  email: string = "";
  password: string = "";



  constructor(private router: Router, public dialog: MatDialog, public userService: UserDataService) {
    this.navLinks = [
      {
        label: 'News',
        link: './newshome',
        index: 0
      }, {
        label: 'Analytics',
        link: './analytic',
        index: 1
      }, {
        label: 'Profile',
        link: './profile',
        index: 2
      },
    ];

  }
  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.navLinks.indexOf(this.navLinks.find(tab => tab.link === '.' + this.router.url));
    });
    this.userService.cast.subscribe(data => {
      console.log(data);
      if (!data && !this.loginDialog) {
        this.openDialog();
      }
    });

  }

  openDialog(): void {
    this.loginDialog = true;
    const dialogRef = this.dialog.open(UserLoginComponent, {
      disableClose: true,
      width: '250px',
      data: { userName: this.userName, email: this.email, password: this.password }
    });


    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      this.userName = result.userName;
      this.email = result.email;
      this.password = result.password;
      this.userService.userEmail = this.email;
      this.userService.userName = this.userName;
      this.loginDialog = false;
      this.userService.changeLogin(true);
      this.router.navigate(['/', 'newshome']);
    });
  }
  logout(): void {
    this.userService.isLoginSuccess = false;
    this.userService.userEmail = "xxx@yy.com";
    this.userService.userName = "";
    this.userService.changeLogin(false);
  }

}
