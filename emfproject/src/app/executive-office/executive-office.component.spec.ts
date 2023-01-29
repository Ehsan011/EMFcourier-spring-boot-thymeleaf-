import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecutiveOfficeComponent } from './executive-office.component';

describe('ExecutiveOfficeComponent', () => {
  let component: ExecutiveOfficeComponent;
  let fixture: ComponentFixture<ExecutiveOfficeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExecutiveOfficeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExecutiveOfficeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
