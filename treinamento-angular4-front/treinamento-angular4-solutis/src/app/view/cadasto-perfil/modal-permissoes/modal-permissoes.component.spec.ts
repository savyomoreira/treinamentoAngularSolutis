import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalPermissoesComponent } from './modal-permissoes.component';

describe('ModalPermissoesComponent', () => {
  let component: ModalPermissoesComponent;
  let fixture: ComponentFixture<ModalPermissoesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalPermissoesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalPermissoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
