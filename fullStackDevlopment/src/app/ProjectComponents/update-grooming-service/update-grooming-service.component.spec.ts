import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateGroomingServiceComponent } from './update-grooming-service.component';

describe('UpdateGroomingServiceComponent', () => {
  let component: UpdateGroomingServiceComponent;
  let fixture: ComponentFixture<UpdateGroomingServiceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateGroomingServiceComponent]
    });
    fixture = TestBed.createComponent(UpdateGroomingServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
