// Import Libraries
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
// Import Services
import { AccountService } from '../../services/account.service';
// Import Models
import { Account } from '../../domain/cmo_db/account';
import { Lessor } from '../../domain/cmo_db/lessor';

// START - USED SERVICES
/**
* AccountService.create
*	@description CRUD ACTION create
*
* AccountService.update
*	@description CRUD ACTION update
*	@param ObjectId id Id
*
* AccountService.get
*	@description CRUD ACTION get
*	@param ObjectId id Id resource
*
*/
// END - USED SERVICES

/**
 * This component allows to edit a Account
 */
@Component({
    selector: 'app-account-edit',
    templateUrl: 'account-edit.component.html',
    styleUrls: ['account-edit.component.css']
})
export class AccountEditComponent implements OnInit {
    item: Account;
    listLessor: Lessor[];
    model: Account;
    formValid: Boolean;

    constructor(
    private accountService: AccountService,
    private route: ActivatedRoute,
    private location: Location) {
        // Init item
        this.item = new Account();
    }

    /**
     * Init
     */
    ngOnInit() {
        this.route.params.subscribe(param => {
            const id: string = param['id'];
            if (id !== 'new') {
                this.accountService.get(id).subscribe(item => this.item = item);
            }
            // Get relations
            this.lessorService.list().subscribe(list => this.listLessor = list);
        });
    }


    /**
     * Save Account
     *
     * @param {boolean} formValid Form validity check
     * @param Account item Account to save
     */
    save(formValid: boolean, item: Account): void {
        this.formValid = formValid;
        if (formValid) {
            if (item._id) {
                this.accountService.update(item).subscribe(data => this.goBack());
            } else {
                this.accountService.create(item).subscribe(data => this.goBack());
            } 
        }
    }

    /**
     * Go Back
     */
    goBack(): void {
        this.location.back();
    }


}



