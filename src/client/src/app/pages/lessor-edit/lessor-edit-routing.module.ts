import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LessorEditComponent } from './lessor-edit.component';

const routes: Routes = [
  {
    path: '',
    component: LessorEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LessorEditRoutingModule { }
