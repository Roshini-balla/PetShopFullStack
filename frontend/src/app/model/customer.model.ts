export class Customer {
  customerId: number;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  street: string;
  city: string;
  state: string;
  zipCode: string;

constructor(customerId: number, firstName: string, lastName: string, email: string, phoneNumber: string, street: string,city:string,state:string,zipCode:string) {
this.customerId=customerId;
this.firstName=firstName;
this.lastName=lastName;
this.email=email;
this.phoneNumber=phoneNumber;
this.street=street;
this.city=city;
this.state=state;
this.zipCode=zipCode;
}}