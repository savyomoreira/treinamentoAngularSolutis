import { ValueUnwrapper } from '@angular/core/src/change_detection/change_detection';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';
import { Headers, RequestOptions, ResponseContentType } from '@angular/http';
import { environment } from 'environments/environment';
import { AbstractHttpService } from './abstract-http.service';

@Injectable()
export class GenericService extends AbstractHttpService{

   private relativePeth;
    
    constructor(relativePeth, http: Http) {
        super(http);
        this.relativePeth = relativePeth;
    }

    save(value){
       return this.postMethod(this.relativePeth, value);
    }

    delete(value){
        return this.deleteMethod(this.relativePeth, value);
     }

    findAll(){
        return this.getMethod(this.relativePeth);
     }

     findOne(value){
        return this.getMethod(this.relativePeth + value);
     }
    
}
