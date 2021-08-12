import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'nj-ng-app';
  navLinks : any[];
  activeLinkIndex = -1;

  constructor(private router: Router){
this.navLinks =[
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
  ngOnInit(): void{
 this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.navLinks.indexOf(this.navLinks.find(tab => tab.link === '.' + this.router.url));
  });

  }

}
