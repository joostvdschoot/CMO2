import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrganizationEditComponent } from './organization-edit.component';
import { OrganizationEditRoutingModule } from './organization-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    OrganizationEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    OrganizationEditComponent
  ]
})
export class OrganizationEditModule { }
