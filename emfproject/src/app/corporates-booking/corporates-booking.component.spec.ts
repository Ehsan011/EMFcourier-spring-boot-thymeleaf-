import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CorporatesBookingComponent } from './corporates-booking.component';

describe('CorporatesBookingComponent', () => {
  let component: CorporatesBookingComponent;
  let fixture: ComponentFixture<CorporatesBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CorporatesBookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CorporatesBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
