import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountListComponent } from './account-list.component';
import { AccountListRoutingModule } from './account-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    AccountListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    AccountListComponent
  ]
})
export class AccountListModule { }
