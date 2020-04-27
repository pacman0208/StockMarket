import { TestBed } from '@angular/core/testing';

import { MenuStoreageService } from './menu-storeage.service';

describe('MenuStoreageService', () => {
  let service: MenuStoreageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MenuStoreageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
