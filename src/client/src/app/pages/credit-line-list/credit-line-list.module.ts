import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLineListComponent } from './credit-line-list.component';
import { CreditLineListRoutingModule } from './credit-line-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    CreditLineListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    CreditLineListComponent
  ]
})
export class CreditLineListModule { }
