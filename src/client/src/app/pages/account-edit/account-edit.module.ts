import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountEditComponent } from './account-edit.component';
import { AccountEditRoutingModule } from './account-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    AccountEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    AccountEditComponent
  ]
})
export class AccountEditModule { }
