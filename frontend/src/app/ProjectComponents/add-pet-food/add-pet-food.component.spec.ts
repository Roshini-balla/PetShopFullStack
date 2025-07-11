import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPetFoodComponent } from './add-pet-food.component';

describe('AddPetFoodComponent', () => {
  let component: AddPetFoodComponent;
  let fixture: ComponentFixture<AddPetFoodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddPetFoodComponent]
    });
    fixture = TestBed.createComponent(AddPetFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
