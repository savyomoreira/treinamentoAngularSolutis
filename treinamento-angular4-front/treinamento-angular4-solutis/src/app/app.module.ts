import { PermissaoService } from './service/permissao-service';
import { PerfilService } from './service/perfil-service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AbstractHttpService} from './service/abstract-http.service';
import { GenericService} from './service/generic.service';

import { Routing} from './app.routing';


import { AppComponent } from './app.component';
import { HeaderComponent } from './view/header/header.component';
import { ExemploComponent } from './view/exemplo/exemplo.component';
import { CadastoPerfilComponent } from './view/cadasto-perfil/cadasto-perfil.component';
import { CadastoPermissoesComponent } from './view/cadasto-permissoes/cadasto-permissoes.component';
import { ListaPermissoesComponent } from './view/cadasto-perfil/lista-permissoes/lista-permissoes.component';
import { ModalPermissoesComponent } from './view/cadasto-perfil/modal-permissoes/modal-permissoes.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ExemploComponent,
    CadastoPerfilComponent,
    CadastoPermissoesComponent,
    ListaPermissoesComponent,
    ModalPermissoesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routing
  ],
  providers: [PerfilService, PermissaoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
