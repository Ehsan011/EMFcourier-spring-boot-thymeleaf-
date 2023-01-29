import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackingDetailsComponent } from './tracking-details.component';

describe('TrackingDetailsComponent', () => {
  let component: TrackingDetailsComponent;
  let fixture: ComponentFixture<TrackingDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrackingDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrackingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
