import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLineEditComponent } from './credit-line-edit.component';
import { CreditLineEditRoutingModule } from './credit-line-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    CreditLineEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    CreditLineEditComponent
  ]
})
export class CreditLineEditModule { }
