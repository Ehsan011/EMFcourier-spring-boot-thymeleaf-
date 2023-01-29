import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CorporatesComponent } from './corporates.component';

describe('CorporatesComponent', () => {
  let component: CorporatesComponent;
  let fixture: ComponentFixture<CorporatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CorporatesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CorporatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
