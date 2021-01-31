import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LessorListComponent } from './lessor-list.component';

const routes: Routes = [
  {
    path: '',
    component: LessorListComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LessorListRoutingModule { }
