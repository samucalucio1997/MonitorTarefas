import { TestBed } from '@angular/core/testing';

import { ApiEditarService } from './api-editar.service';

describe('ApiEditarService', () => {
  let service: ApiEditarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiEditarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
