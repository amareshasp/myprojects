import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormArray, FormControl } from '@angular/forms';
import { UserDataService } from '../../service/user-data.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css'],
})
export class UserFormComponent implements OnInit {
  myForm: FormGroup = new FormGroup({});
  newsAgencyList: string[] = [];
  newsAgency: any[] = [
    { name: 'The Times of India' },
    { name: 'The Hindu' },
    { name: 'Deccan Herald' },
    { name: 'Hindustan Times ' },
    { name: 'The Economics Times' },
    { name: 'The Indian Express' },
    { name: 'The Telegraph' },
  ];
  constructor(private fb: FormBuilder, private userService : UserDataService) {}

  ngOnInit(): void {
    this.myForm = this.fb.group({
      name: '',
      age: '',
      email: '',
      subs: this.fb.array([
        this.fb.group({
          agency: [''],
          sport: [''],
          event: [''],
          entertainment: [''],
          politics: [''],
          tech: [''],
        }),
      ]),
    });

    this.userService.sendGetRequest().subscribe((data: any) => {
      console.log(data);
      this.myForm = this.fb.group({
        name: new FormControl(data.userName),
        age: data.age,
        email: data.userMail,
        subs: this.fb.array(
          data.subscriptions.map((datum: any) => this.generateDatumFormGroup(datum))
        ),
      });
    });

    /*this.addPhoneTOISports();*/
    this.myForm.valueChanges.subscribe(console.log);
  }

  private generateDatumFormGroup(datum: any) {
    console.log(datum);
      //this.newsAgency = this.newsAgency.filter(item => item === datum.agency);  
    this.newsAgencyList.push(datum.agency);
    console.log(this.isExists(datum.topics, 'Sports'));
    const obj = this.fb.group({
      agency: new FormControl(datum.agency),
      sport: new FormControl(this.isExists(datum.topics, 'Sports')),
      event: new FormControl(this.isExists(datum.topics, 'Events')),
      entertainment: new FormControl(this.isExists(datum.topics, 'Entertainment')),
      politics: new FormControl(this.isExists(datum.topics, 'Politics')),
      tech: new FormControl(this.isExists(datum.topics, 'Technology')),
    });

return obj;
  }

  isExists(arr: string[], val:string){
return arr.some(function(e){return e===val});
  }

  get newSubs() {
    return this.myForm.get('subs') as FormArray;
  }

 
  addPhone() {
    const subs = this.fb.group({
      agency: [''],
      sport: [''],
      event: [''],
      entertainment: [''],
      politics: [''],
      tech: [''],
    });
    this.newSubs.push(subs);
  }
  deletePhone(i: number) {
    this.newSubs.removeAt(i);
  }

  isDisabled(value : string) {
    const i = this.newsAgencyList.indexOf(value);
    if (i >= 0){
      return true;
    }
    return false;
  }

}
