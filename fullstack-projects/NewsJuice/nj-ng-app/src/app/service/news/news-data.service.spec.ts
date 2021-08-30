import { TestBed } from '@angular/core/testing';

import { NewsDataService } from './news-data.service';

describe('NewsDataService', () => {
  let service: NewsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
