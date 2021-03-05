import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  user: User;

  constructor(private http: HttpClient) {
    this.user = new User();
}

  ngOnInit(): void {
  }

  onSubmit() {
    this.saveUser(this.user);
  }

  saveUser(user: User) {
    console.log("user ", user);
    this.http.post('https://knl9bom448.execute-api.us-east-1.amazonaws.com/dev', user).subscribe(
      (response) => console.log(response),
      (error) => console.log(error)
    );
  }

}
