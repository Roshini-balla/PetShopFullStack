import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClient, HttpClientModule} from'@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddGroomingServiceComponent } from './ProjectComponents/add-grooming-service/add-grooming-service.component';
import { UpdateGroomingServiceComponent } from './ProjectComponents/update-grooming-service/update-grooming-service.component';
import { MatDialogModule } from '@angular/material/dialog';

import { VaccinationListComponent } from './ProjectComponents/vaccination-list/vaccination-list.component';
import { AddVaccinationComponent } from './ProjectComponents/add-vaccination/add-vaccination.component';
import { UpdateVaccinationComponent } from './ProjectComponents/update-vaccination/update-vaccination.component';
import { VaccinationDetailsComponent } from './ProjectComponents/vaccination-details/vaccination-details.component';
import { PetListComponent } from './ProjectComponents/pet-list/pet-list.component';
import { AddPetComponent } from './ProjectComponents/add-pet/add-pet.component';
import { UpdatePetComponent } from './ProjectComponents/update-pet/update-pet.component';
import { PetDetailsComponent } from './ProjectComponents/pet-details/pet-details.component';

import { CommonModule } from '@angular/common';
import { CustomerComponent } from './ProjectComponents/customer/customer.component';
import { AddCustomerComponent } from './ProjectComponents/add-customer/add-customer.component';
import { AddPetFoodComponent } from './ProjectComponents/add-pet-food/add-pet-food.component';
import { UpdatePetFoodComponent } from './ProjectComponents/update-pet-food/update-pet-food.component';
import { PetFoodListComponent } from './ProjectComponents/pet-food-list/pet-food-list.component';
import { GroomingServicesComponent } from './ProjectComponents/grooming-services/grooming-services.component';
import { HomeComponent } from './home/home.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { TransactionsComponent } from './ProjectComponents/transactions/transactions.component';
import { UpdateCustomerComponent } from './ProjectComponents/update-customer/update-customer.component';


import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';




@NgModule({
  declarations: [
    AppComponent,
    PetListComponent,
    AddPetComponent,
    UpdatePetComponent,
    PetDetailsComponent,
    PetFoodListComponent,
    AddPetFoodComponent,
    UpdatePetFoodComponent,
    GroomingServicesComponent,
    AddGroomingServiceComponent,
    UpdateGroomingServiceComponent,
    CustomerComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    VaccinationListComponent,
    AddVaccinationComponent,
    UpdateVaccinationComponent,
    VaccinationDetailsComponent,
   TransactionsComponent,
    HomeComponent,
    

    
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDialogModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    MatSnackBarModule,
    BrowserAnimationsModule,

    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatFormFieldModule,



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
