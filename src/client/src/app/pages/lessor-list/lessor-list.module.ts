import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LessorListComponent } from './lessor-list.component';
import { LessorListRoutingModule } from './lessor-list-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    LessorListRoutingModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    LessorListComponent
  ]
})
export class LessorListModule { }
