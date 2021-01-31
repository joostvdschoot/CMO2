import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
// Import Services
import { CreditLineService } from '../../services/credit-line.service';
// Import Models
import { CreditLine } from '../../domain/cmo_db/credit-line';

// START - USED SERVICES
/**
* CreditLineService.delete
*	@description CRUD ACTION delete
*	@param ObjectId id Id
*
* CreditLineService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component shows a list of CreditLine
 * @class CreditLineListComponent
 */
@Component({
    selector: 'app-credit-line-list',
    templateUrl: './credit-line-list.component.html',
    styleUrls: ['./credit-line-list.component.css']
})
export class CreditLineListComponent implements OnInit {
    list: CreditLine[];
    search: any = {};
    idSelected: string;
    constructor(
        private creditlineService: CreditLineService,
    ) { }

    /**
     * Init
     */
    ngOnInit(): void {
        this.creditlineService.list().subscribe(list => this.list = list);
    }

    /**
     * Select CreditLine to remove
     *
     * @param {string} id Id of the CreditLine to remove
     */
    selectId(id: string) {
        this.idSelected = id;
    }

    /**
     * Remove selected CreditLine
     */
    deleteItem() {
        this.creditlineService.remove(this.idSelected).subscribe(data => this.list = this.list.filter(el => el._id !== this.idSelected));
    }

}
