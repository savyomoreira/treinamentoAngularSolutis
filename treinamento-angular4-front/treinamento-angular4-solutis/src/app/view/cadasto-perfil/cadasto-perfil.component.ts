import { ListaPermissoesComponent } from './lista-permissoes/lista-permissoes.component';
import { PermissaoService } from '../../service/permissao-service';
import { PerfilService } from '../../service/perfil-service';
import { Component, OnInit } from '@angular/core';


import { ElementRef } from '@angular/core';
import { ViewChild } from '@angular/core';

@Component({
  selector: 'app-cadasto-perfil',
  templateUrl: './cadasto-perfil.component.html',
  styleUrls: ['./cadasto-perfil.component.css']
})
export class CadastoPerfilComponent implements OnInit {

  permissoesList: Array<any>;
  perfil: any;

  @ViewChild('listPerfis') 
  listPerfisComponent: ListaPermissoesComponent;

  constructor(private perfilService: PerfilService, private permissaoService: PermissaoService) { 

  }

  save(){
    this.perfilService.save(this.perfil).then(data => {
      this.listPerfisComponent.addPerfil(this.perfil);
      alert('Salvo com Sucesso');
    });
  }

  remover(event){
    this.perfilService.delete(event.param.id).then(data => {
      alert('removido com Sucesso');
    });
  }

  initPerfil(){
    return {
      id: null,
      nomePerfil:"",
      descricao: ""
    };
  }

  ngOnInit() {
    this.perfil = this.initPerfil();
    this.perfilService.findAll().subscribe(data => {
      this.permissoesList = data.ge;
      this.listPerfisComponent.setListPerfis(data);
    });
  }

}
