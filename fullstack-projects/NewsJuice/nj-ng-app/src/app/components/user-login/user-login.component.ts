import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UserDataService } from '../../service/user-data.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  loginMessage: string = "";

  email: string = "";
  password: string = "";
  showSpinner: boolean = false;

  constructor(
    public dialogRef: MatDialogRef<UserLoginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private userService: UserDataService) { }

  ngOnInit(): void {
    //  throw new Error('Method not implemented.');
  }

  onNoClick(): void {
    this.reset();
    this.showSpinner = true;
    this.userService.sendGetRequestByEmail(this.email).subscribe((data: any) => {
      console.log(data);
      this.showSpinner = false;
      if (!data) {
        this.userService.isLoginSuccess = false;
        this.loginMessage = "User not found!";
        this.userService.changeLogin(false);
      } else {

        if (data.error) {
          this.userService.isLoginSuccess = false;
          this.loginMessage = "Error occured!";
          this.userService.changeLogin(false);
        } else {
          this.userService.isLoginSuccess = true;
          this.userService.changeLogin(true);
          this.dialogRef.close({
            userName: data.userName,
            email: data.userMail,
            password: this.password
          });
        }

      }


    });


  }

  reset() {

    this.loginMessage = "";

  }


}
