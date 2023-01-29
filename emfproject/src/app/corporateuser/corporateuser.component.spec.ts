import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CorporateuserComponent } from './corporateuser.component';

describe('CorporateuserComponent', () => {
  let component: CorporateuserComponent;
  let fixture: ComponentFixture<CorporateuserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CorporateuserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CorporateuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
