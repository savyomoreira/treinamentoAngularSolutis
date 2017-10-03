import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastoPerfilComponent } from './cadasto-perfil.component';

describe('CadastoPerfilComponent', () => {
  let component: CadastoPerfilComponent;
  let fixture: ComponentFixture<CadastoPerfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastoPerfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastoPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
