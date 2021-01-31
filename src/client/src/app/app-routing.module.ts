// DEPENDENCIES
import { NgModule } from '@angular/core';
import { CanActivate, RouterModule, Routes } from '@angular/router';

/* START MY VIEWS IMPORT */
// Do not edit this comment content, it will be overwritten in next Skaffolder generation
import { HomeComponent} from './pages/home/home.component';
import { AccountEditComponent} from './pages/account-edit/account-edit.component';
import { AccountListComponent} from './pages/account-list/account-list.component';
import { CreditLineEditComponent} from './pages/credit-line-edit/credit-line-edit.component';
import { CreditLineListComponent} from './pages/credit-line-list/credit-line-list.component';
import { LessorEditComponent} from './pages/lessor-edit/lessor-edit.component';
import { LessorListComponent} from './pages/lessor-list/lessor-list.component';
import { OrganizationEditComponent} from './pages/organization-edit/organization-edit.component';
import { OrganizationListComponent} from './pages/organization-list/organization-list.component';

/* END MY VIEWS IMPORT */

// SECURITY
import { LoginComponent } from './pages/login/login.component';
import { ManageUserEditComponent } from './security/manage-user/edit-user/manage-user-edit.component';
import { ManageUserListComponent } from './security/manage-user/list-user/manage-user-list.component';
import { ProfileComponent } from './security/profile/profile.component';
import { AuthGuard } from './security/auth.guard';

/**
 * WEB APP ROUTES
 */
const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full'  },

    /* START MY VIEWS */

    { path: 'accounts/:id',  loadChildren: './pages/account-edit/account-edit.module#AccountEditModule' , canActivate: [AuthGuard] },
    { path: 'accounts',  loadChildren: './pages/account-list/account-list.module#AccountListModule' , canActivate: [AuthGuard] },
    { path: 'creditlines/:id',  loadChildren: './pages/credit-line-edit/credit-line-edit.module#CreditLineEditModule' , canActivate: [AuthGuard] },
    { path: 'creditlines',  loadChildren: './pages/credit-line-list/credit-line-list.module#CreditLineListModule' , canActivate: [AuthGuard] },
    { path: 'home',  loadChildren: './pages/home/home.module#HomeModule' , canActivate: [AuthGuard] },
    { path: 'lessors/:id',  loadChildren: './pages/lessor-edit/lessor-edit.module#LessorEditModule' , canActivate: [AuthGuard] },
    { path: 'lessors',  loadChildren: './pages/lessor-list/lessor-list.module#LessorListModule' , canActivate: [AuthGuard] },
    { path: 'organizations/:id',  loadChildren: './pages/organization-edit/organization-edit.module#OrganizationEditModule' , canActivate: [AuthGuard] },
    { path: 'organizations',  loadChildren: './pages/organization-list/organization-list.module#OrganizationListModule' , canActivate: [AuthGuard] },

 /* END MY VIEWS */

    // SECURITY
    { path: 'manage-users',  loadChildren: './security/manage-user/list-user/manage-user-list.module#ManageUserListModule', canActivate: [AuthGuard], data: ['ADMIN']},
    { path: 'manage-users/:id',  loadChildren: './security/manage-user/edit-user/manage-user-edit.module#ManageUserEditModule', canActivate: [AuthGuard], data: ['ADMIN']},
    { path: 'profile',  loadChildren: './security/profile/profile.module#ProfileModule', canActivate: [AuthGuard] },
    { path: 'login', loadChildren: './pages/login/login.module#LoginModule'}
];

/**
 * ROUTING MODULE
 */
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}
