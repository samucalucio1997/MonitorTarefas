import { TestBed } from '@angular/core/testing';

import { TarefaApiService } from './tarefa-api.service';

describe('TarefaApiService', () => {
  let service: TarefaApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TarefaApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
