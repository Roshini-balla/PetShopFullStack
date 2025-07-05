import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGroomingServiceComponent } from './add-grooming-service.component';

describe('AddGroomingServiceComponent', () => {
  let component: AddGroomingServiceComponent;
  let fixture: ComponentFixture<AddGroomingServiceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddGroomingServiceComponent]
    });
    fixture = TestBed.createComponent(AddGroomingServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
