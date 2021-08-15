import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormArray, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  myForm: FormGroup = new FormGroup({}) ;

  constructor(private fb : FormBuilder,   private http: HttpClient) { 
  

  }

  ngOnInit(): void {
      this.myForm = this.fb.group({
      name: '',
      age:'',
      email: '',
      subs: this.fb.array([
          this.fb.group({
         agency: [''] ,
         sport: [''],
         event: [''],
         entertainment: [''],
         politics: [''],
         tech: [''],
       })
      ])
    });

      this.http.get('/assets/formdata.json')
      .subscribe((data: any) => {
        this.myForm = this.fb.group({
          name: new FormControl(data.name),
          age: data.age,
          email: data.email,
          subs: this.fb.array(data.subs.map((datum: any)=> this.generateDatumFormGroup(datum)))
        });
      });


/*this.addPhoneTOISports();*/
  this.myForm.valueChanges.subscribe(console.log);

  }

  
  private generateDatumFormGroup(datum:any) {
    console.log(datum);
    return this.fb.group( {
      agency:  new FormControl(datum.agency),
      sport: new FormControl(datum.sport),
      event: new FormControl(datum.event),
      entertainment: new FormControl(datum.entertainment),
      politics: new FormControl(datum.politics),
      tech: new FormControl(datum.tech)                        
    });
  }

  get newSubs(){
return this.myForm.get('subs') as FormArray;
  }

  
  addPhoneTOISports(){
    const subs = this.fb.group({
      agency:'TOI',
      sport:true
    })
    this.newSubs.push(subs);
  }
  addPhone(){
    const subs = this.fb.group({
      agency:[],
      sport:[]
    })
    this.newSubs.push(subs);
  }
  deletePhone(i: number){
    this.newSubs.removeAt(i);
  }

}
