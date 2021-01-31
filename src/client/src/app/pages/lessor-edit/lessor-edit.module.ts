import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LessorEditComponent } from './lessor-edit.component';
import { LessorEditRoutingModule } from './lessor-edit-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    LessorEditRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    LessorEditComponent
  ]
})
export class LessorEditModule { }
