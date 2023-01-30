import { TestBed } from '@angular/core/testing';

import { DeliverymanService } from './deliveryman.service';

describe('DeliverymanService', () => {
  let service: DeliverymanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeliverymanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
