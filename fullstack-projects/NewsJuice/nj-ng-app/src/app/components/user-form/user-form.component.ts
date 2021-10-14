import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormArray, FormControl } from '@angular/forms';
import { UserDataService } from '../../service/user-data.service';
import { UserModel } from 'src/app/model/user.model';
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css'],
})
export class UserFormComponent implements OnInit {
  myForm: FormGroup = new FormGroup({});
  newsAgencyList: string[] = [];
  usermodel!: UserModel;
  showSpinner: boolean = false;

  newsAgency: any[] = [
    { name: 'The Times of India' },
    { name: 'The Hindu' },
    { name: 'Deccan Herald' },
    { name: 'Hindustan Times ' },
    { name: 'The Economics Times' },
    { name: 'The Indian Express' },
    { name: 'The Telegraph' },
  ];
  constructor(private fb: FormBuilder, private userService: UserDataService) { }

  ngOnInit(): void {
    this.myForm = this.fb.group({
      uid: '',
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

    this.showSpinner = true;
    this.userService.sendGetRequest().subscribe((data: any) => {
      console.log(data);
      this.showSpinner = false;
      if (data) {
        this.myForm = this.fb.group({
          uid: data.userId,
          name: new FormControl(data.userName),
          age: data.age,
          email: data.userMail,
          subs: this.fb.array(
            data.subscriptions.map((datum: any) => this.generateDatumFormGroup(datum))
          ),
        });
      }

    });

    /*this.addPhoneTOISports();*/
    this.myForm.valueChanges.subscribe(console.log);
  }

  private generateDatumFormGroup(datum: any) {
    console.log(datum);
    //this.newsAgency = this.newsAgency.filter(item => item === datum.agency);  
    this.newsAgencyList.push(datum.agency);
    console.log(this.isExists(datum.channel, 'Sports'));
    const obj = this.fb.group({
      agency: new FormControl(datum.agency),
      sport: new FormControl(this.isExists(datum.channel, 'Sports')),
      event: new FormControl(this.isExists(datum.channel, 'Events')),
      entertainment: new FormControl(this.isExists(datum.channel, 'Entertainment')),
      politics: new FormControl(this.isExists(datum.channel, 'Politics')),
      tech: new FormControl(this.isExists(datum.channel, 'Technology')),
    });

    return obj;
  }

  isExists(arr: string[], val: string) {
    return arr.some(function (e) { return e === val });
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

  isDisabled(value: string) {
    const i = this.newsAgencyList.indexOf(value);
    if (i >= 0) {
      return true;
    }
    return false;
  }

  submit() {

    console.log("Submit trigger");
    if (!this.myForm.valid) {
      return;
    }

    this.transform();
    console.log(this.usermodel);


    this.userService.sendPostRequest(this.usermodel).subscribe((data: any) => {
      console.log(data);

    });


  }

  transform() {
    this.usermodel = new UserModel();
    let channels: string[] = [];
    this.usermodel.userName = this.myForm.value.name;
    this.usermodel.userId = this.myForm.value.uid;
    this.usermodel.age = this.myForm.value.age;
    this.usermodel.userMail = this.myForm.value.email;
    for (let sub of this.myForm.value.subs) {
      console.log('subsc-', sub);
      if (sub.sport === true) {
        channels.push("Sports");
      }
      if (sub.entertainment === true) {
        channels.push("Entertainment");
      }
      if (sub.event === true) {
        channels.push("Events");
      }
      if (sub.politics === true) {
        channels.push("Politics");
      }
      if (sub.tech === true) {
        channels.push("Technology");
      }
      this.usermodel.subscriptions.push({ agency: sub.agency, channel: channels });
      channels = [];
    }
  }

}
