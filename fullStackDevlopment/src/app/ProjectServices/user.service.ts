import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private users = new Map<string, string>(); // key: username, value: password

  constructor() {}

  register(username: string, password: string): void {
    this.users.set(username, password);
  }

  login(username: string, password: string): boolean {
    return this.users.get(username) === password;
  }
}
