import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePetFoodComponent } from './update-pet-food.component';

describe('UpdatePetFoodComponent', () => {
  let component: UpdatePetFoodComponent;
  let fixture: ComponentFixture<UpdatePetFoodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdatePetFoodComponent]
    });
    fixture = TestBed.createComponent(UpdatePetFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
