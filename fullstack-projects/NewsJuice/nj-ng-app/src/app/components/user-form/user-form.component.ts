import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormArray } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  myForm: FormGroup = new FormGroup({}) ;

  constructor(private fb : FormBuilder) { 
  

  }

  ngOnInit(): void {
  this.myForm = this.fb.group({
      name: '',
      age:'',
      email: '',
      subs: this.fb.array([])
    });
this.addPhoneTOISports();
  this.myForm.valueChanges.subscribe(console.log);

  }

  get newSubs(){
return this.myForm.get('subs') as FormArray;
  }

  
  addPhoneTOISports(){
    const subs = this.fb.group({
      agency:'TOI',
      sport:true,
      event:[],
      entertainment:[],
      politics:[],
      tech:[]
    })
    this.newSubs.push(subs);
  }
  addPhone(){
    const subs = this.fb.group({
      agency:[],
      sport:[],
      event:[],
      entertainment:[],
      politics:[],
      tech:[]
    })
    this.newSubs.push(subs);
  }
  deletePhone(i: number){
    this.newSubs.removeAt(i);
  }

}
