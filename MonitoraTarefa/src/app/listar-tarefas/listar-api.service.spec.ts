import { TestBed } from '@angular/core/testing';

import { ListarApiService } from './listar-api.service';

describe('ListarApiService', () => {
  let service: ListarApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListarApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
