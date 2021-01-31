import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
// Import Services
import { AccountService } from '../../services/account.service';
// Import Models
import { Account } from '../../domain/cmo_db/account';

// START - USED SERVICES
/**
* AccountService.delete
*	@description CRUD ACTION delete
*	@param ObjectId id Id
*
* AccountService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component shows a list of Account
 * @class AccountListComponent
 */
@Component({
    selector: 'app-account-list',
    templateUrl: './account-list.component.html',
    styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {
    list: Account[];
    search: any = {};
    idSelected: string;
    constructor(
        private accountService: AccountService,
    ) { }

    /**
     * Init
     */
    ngOnInit(): void {
        this.accountService.list().subscribe(list => this.list = list);
    }

    /**
     * Select Account to remove
     *
     * @param {string} id Id of the Account to remove
     */
    selectId(id: string) {
        this.idSelected = id;
    }

    /**
     * Remove selected Account
     */
    deleteItem() {
        this.accountService.remove(this.idSelected).subscribe(data => this.list = this.list.filter(el => el._id !== this.idSelected));
    }

}
