import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreditLineListComponent } from './credit-line-list.component';

const routes: Routes = [
  {
    path: '',
    component: CreditLineListComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreditLineListRoutingModule { }
