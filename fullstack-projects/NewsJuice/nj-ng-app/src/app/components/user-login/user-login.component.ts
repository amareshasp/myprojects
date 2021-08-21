import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {


  email: string ="";
  password: string ="";

  constructor(
    public dialogRef: MatDialogRef<UserLoginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
  //  throw new Error('Method not implemented.');
  }

  onNoClick(): void {
    this.dialogRef.close({
      email: this.email,
      password :this.password
    });
  }


}
