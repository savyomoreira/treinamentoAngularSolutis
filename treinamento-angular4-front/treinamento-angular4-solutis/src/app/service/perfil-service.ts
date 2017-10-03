import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';


@Injectable()
export class PerfilService extends GenericService{

    constructor(http: Http) {
        super('perfil', http);
    }
    
}
