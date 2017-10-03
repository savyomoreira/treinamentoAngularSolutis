import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';


@Injectable()
export class SistemaService extends GenericService{

    constructor(http: Http) {
        super('sistema', http);
    }
    
}
