import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { ElementRef } from '@angular/core';
import { ViewChild } from '@angular/core';


import { ModalPermissoesComponent } from './../modal-permissoes/modal-permissoes.component';

@Component({
  selector: 'app-lista-permissoes',
  templateUrl: './lista-permissoes.component.html',
  styleUrls: ['./lista-permissoes.component.css']
})
export class ListaPermissoesComponent implements OnInit {

  listPerfis: Array<any>;

  @Output()
  eventdelete = new EventEmitter();

  constructor() { }

  ngOnInit() {
    this.listPerfis = new Array();
  }

  setListPerfis(listPerfis){
    this.listPerfis = listPerfis;
    console.log(listPerfis)
    console.log('list')
  }

  addPerfil(perfil){
    perfil.nome = perfil.nomePerfil;
    this.listPerfis.push(perfil);
  }

  removeperfil(perfil){
    this.eventdelete.emit({ param: perfil });
    this.listPerfis = this.listPerfis.filter(data => data != perfil);
  }

}
