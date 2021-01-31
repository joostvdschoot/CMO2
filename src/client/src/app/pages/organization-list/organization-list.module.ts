import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrganizationListComponent } from './organization-list.component';
import { OrganizationListRoutingModule } from './organization-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    OrganizationListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    OrganizationListComponent
  ]
})
export class OrganizationListModule { }
