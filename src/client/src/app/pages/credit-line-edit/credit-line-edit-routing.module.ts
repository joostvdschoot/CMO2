import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreditLineEditComponent } from './credit-line-edit.component';

const routes: Routes = [
  {
    path: '',
    component: CreditLineEditComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreditLineEditRoutingModule { }
