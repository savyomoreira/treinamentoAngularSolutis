import { Routes, RouterModule } from '@angular/router';
import {ExemploComponent} from './view/exemplo/exemplo.component'
import {CadastoPermissoesComponent} from './view/cadasto-permissoes/cadasto-permissoes.component'
import {CadastoPerfilComponent} from './view/cadasto-perfil/cadasto-perfil.component'


const appRoutes: Routes = [
 { path: 'cadastro-permissoes', component: CadastoPermissoesComponent},
 { path: 'cadastro-perfil', component: CadastoPerfilComponent},
 { path: '**', component: ExemploComponent},
];

export const Routing = RouterModule.forRoot(appRoutes, { useHash: true })