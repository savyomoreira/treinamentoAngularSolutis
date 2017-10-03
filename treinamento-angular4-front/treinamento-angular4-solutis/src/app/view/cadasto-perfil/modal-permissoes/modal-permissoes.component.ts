import { Component, OnInit } from '@angular/core';

import { ElementRef } from '@angular/core';
import { ViewChild } from '@angular/core';

@Component({
  selector: 'app-modal-permissoes',
  templateUrl: './modal-permissoes.component.html',
  styleUrls: ['./modal-permissoes.component.css']
})
export class ModalPermissoesComponent implements OnInit {

  @ViewChild('closeBtn')
  closeBtn: ElementRef;

  @ViewChild('openBtn') 
  openBtn: ElementRef;

  constructor() { }

  ngOnInit() {
  }

  openModal(){
    console.log('sdsd')
    this.openBtn.nativeElement.click()
  }

  closeModal(){
    this.closeBtn.nativeElement.click()
  }

}
