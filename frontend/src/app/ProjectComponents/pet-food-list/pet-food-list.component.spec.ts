import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetFoodListComponent } from './pet-food-list.component';

describe('PetFoodListComponent', () => {
  let component: PetFoodListComponent;
  let fixture: ComponentFixture<PetFoodListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PetFoodListComponent]
    });
    fixture = TestBed.createComponent(PetFoodListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
