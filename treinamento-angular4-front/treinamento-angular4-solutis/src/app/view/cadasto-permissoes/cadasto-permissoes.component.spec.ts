import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastoPermissoesComponent } from './cadasto-permissoes.component';

describe('CadastoPermissoesComponent', () => {
  let component: CadastoPermissoesComponent;
  let fixture: ComponentFixture<CadastoPermissoesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastoPermissoesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastoPermissoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
