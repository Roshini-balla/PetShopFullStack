import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VaccinationListComponent } from './ProjectComponents/vaccination-list/vaccination-list.component';
import { AddVaccinationComponent } from './ProjectComponents/add-vaccination/add-vaccination.component';
import { UpdateVaccinationComponent } from './ProjectComponents/update-vaccination/update-vaccination.component';
import { VaccinationDetailsComponent } from './ProjectComponents/vaccination-details/vaccination-details.component';
import { PetListComponent } from './ProjectComponents/pet-list/pet-list.component';
import { AddPetComponent } from './ProjectComponents/add-pet/add-pet.component';
import { UpdatePetComponent } from './ProjectComponents/update-pet/update-pet.component';
import { AddGroomingServiceComponent } from './ProjectComponents/add-grooming-service/add-grooming-service.component';
import { UpdateGroomingServiceComponent } from './ProjectComponents/update-grooming-service/update-grooming-service.component';
import { CustomerComponent } from './ProjectComponents/customer/customer.component';
import { AddCustomerComponent } from './ProjectComponents/add-customer/add-customer.component';
import { PetFoodListComponent } from './ProjectComponents/pet-food-list/pet-food-list.component';
import { AddPetFoodComponent } from './ProjectComponents/add-pet-food/add-pet-food.component';
import { UpdatePetFoodComponent } from './ProjectComponents/update-pet-food/update-pet-food.component';
import { GroomingServicesComponent } from './ProjectComponents/grooming-services/grooming-services.component';
import { HomeComponent } from './home/home.component';
import { PetDetailsComponent } from './ProjectComponents/pet-details/pet-details.component';
import { TransactionsComponent } from './ProjectComponents/transactions/transactions.component';
import { UpdateCustomerComponent } from './ProjectComponents/update-customer/update-customer.component';


const routes: Routes = [

 
 { path: '', redirectTo: '/home',pathMatch:'full'}  ,
 {path:'home',component:HomeComponent},

  { path: 'pets', component: PetListComponent },
  { path: 'pet-foods', component: PetFoodListComponent },


 { path: 'pets', component: PetListComponent },
 { path: 'add-pet', component: AddPetComponent },
 { path: 'pet-details/:id', component: PetDetailsComponent },
 { path: 'update-pet/:id', component: UpdatePetComponent },
 { path: 'grooming-services', component: GroomingServicesComponent },
 { path: 'customers', component: CustomerComponent },
 { path: 'vaccinations', component: VaccinationListComponent },

 
 { path: 'pet-foods', component: PetFoodListComponent },
 { path: 'add-pet-food', component: AddPetFoodComponent },
 { path: 'update-pet-food/:foodId', component: UpdatePetFoodComponent },
 
  { path: 'grooming-services', component: GroomingServicesComponent },
  { path: 'add-grooming-service', component: AddGroomingServiceComponent },
  { path: 'update-grooming-service/:service_id', component: UpdateGroomingServiceComponent },
  
  { path: 'customers', component: CustomerComponent },
  { path: 'add-customer', component: AddCustomerComponent },
  {path:'update-customer/:customerId',component:UpdateCustomerComponent},

  { path: 'vaccinations', component: VaccinationListComponent },
  { path: 'add-vaccination', component: AddVaccinationComponent },
  { path: 'update-vaccination/:vaccinationId', component: UpdateVaccinationComponent },
  { path: 'vaccination-details/:vaccinationId', component: VaccinationDetailsComponent },

  {path:'transactions',component:TransactionsComponent},
  

  
 
  
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
