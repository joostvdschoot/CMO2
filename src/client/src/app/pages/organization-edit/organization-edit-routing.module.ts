import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrganizationEditComponent } from './organization-edit.component';

const routes: Routes = [
  {
    path: '',
    component: OrganizationEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrganizationEditRoutingModule { }
