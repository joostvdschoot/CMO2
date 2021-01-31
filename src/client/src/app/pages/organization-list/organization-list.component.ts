import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
// Import Services
import { OrganizationService } from '../../services/organization.service';
// Import Models
import { Organization } from '../../domain/cmo_db/organization';

// START - USED SERVICES
/**
* OrganizationService.delete
*	@description CRUD ACTION delete
*	@param ObjectId id Id
*
* OrganizationService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component shows a list of Organization
 * @class OrganizationListComponent
 */
@Component({
    selector: 'app-organization-list',
    templateUrl: './organization-list.component.html',
    styleUrls: ['./organization-list.component.css']
})
export class OrganizationListComponent implements OnInit {
    list: Organization[];
    search: any = {};
    idSelected: string;
    constructor(
        private organizationService: OrganizationService,
    ) { }

    /**
     * Init
     */
    ngOnInit(): void {
        this.organizationService.list().subscribe(list => this.list = list);
    }

    /**
     * Select Organization to remove
     *
     * @param {string} id Id of the Organization to remove
     */
    selectId(id: string) {
        this.idSelected = id;
    }

    /**
     * Remove selected Organization
     */
    deleteItem() {
        this.organizationService.remove(this.idSelected).subscribe(data => this.list = this.list.filter(el => el._id !== this.idSelected));
    }

}
